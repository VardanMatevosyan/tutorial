-- Properly using index scan
-- 1 RULE - Avoiding <> != operations

-- BAD SQL query, because the index is suppresed
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id <> 1;

-- GOOD SQL query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id > 1 OR p.id < 1;

-- 2 RULE - Avoid using SUBSTR function it disables the index scan usage
-- BAD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE SUBSTR(p.nick_name, 1, 4) = 'Nick';

-- GOOD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.nick_name LIKE 'Nick%';


-- 3 RULE - Avoid using + - / * operations.
-- If there is insufficient data, sequence scan will be used even if there is index for the column
-- BAD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id + 5000000 > 5000215;

-- GOOD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id > 215;

-- like
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id > 5000215 - 5000000;

-- or we can use function based index


-- 4 RULE - Avoid using DATE_TRUNC function. For example compare if it's the first day of the month
-- BAD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name, p.created_at
FROM profile AS p
WHERE DATE_TRUNC('day', p.created_at) = '2023-11-01';

-- GOOD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name, p.created_at
FROM profile AS p
WHERE p.created_at between '2023-11-01' and '2023-11-02';



-- 5 RULE - Avoid using || operation
-- BAD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name, p.created_at
FROM profile AS p
WHERE p.nick_name || p.id = 'Var5';

-- GOOD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name, p.created_at
FROM profile AS p
WHERE p.nick_name = 'Var' and p.id = 5;



-- 6 RULE - For Oracle - Avoid using IS NULL or NOT NULL for index column
--          For PostgreSQL it will use the index anyway
-- BAD query For Oracle
-- This query is normal for PostgreSQL because it will use the index anyway
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name, p.created_at
FROM profile AS p
WHERE p.nick_name IS NULL;

-- GOOD query for Oracle
-- The Oracle will use the index if we use NVL function
-- and will replace NULL with some marker and will use NULL value in index
CREATE INDEX idx_nick_name_null ON profile (NVL(nick_name, 'IS_NULL_MARKER'));

EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name, p.created_at
FROM profile AS p
WHERE NVL(p.nick_name, 'IS_NULL_MARKER') = 'IS_NULL_MARKER';


-- 7 RULE - Avoid using functions for column with index
-- BAD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name, p.created_at
FROM profile AS p
WHERE SUBSTR(p.nick_name, 1, 3) = 'Var';

-- Insted use index based functions
-- GOOD query with index based function
CREATE INDEX substring_function_inx ON profile(SUBSTR(nick_name, 1, 3));



-- 8 RULE - Use UNION ALL instead of UNION

-- BAD SQL query, because the index is suppresed
-- when there are million of records then Postgres will use UNIQUE SORT
-- when there are less data then it will use Aggregate
-- all these are expensive
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id > 2000 OR p.id < 2003
UNION
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.nick_name = 'Var';

-- GOOD SQL query
-- UNION ALL does not use unque sort and aggregate
-- it uses only Append after index scan or seq scan if less data to retrieve
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id > 2000 OR p.id < 2003
UNION ALL
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.nick_name = 'Var';

-- or UNION ALL with DISTINCT
SELECT DISTINCT id, nick_name
FROM (
  SELECT id, nick_name FROM profile WHERE id > 2000 OR id < 2003
  UNION ALL
  SELECT id, nick_name FROM profile WHERE nick_name = 'Var'
) AS combined;



-- 10 RULE - Minimise table lookups for example using sub query

-- BAD SQL query
-- all these are expensive
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id IN (SELECT p.id
               FROM profile AS p
               WHERE p.id > 2000 OR p.id < 2003)
  AND
    p.id IN (	SELECT p.id
                 FROM profile AS p
                 WHERE p.nick_name = 'Var');

-- GOOD SQL query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id IN (SELECT p.id
               FROM profile AS p
               WHERE (p.id > 2000 OR p.id < 2003)
                 AND p.nick_name = 'Var');



-- 11 RULE - IN, NOT IN, EXISTS
-- a. If there is big table in outer query and small table in inner query
--    better to use IN clause
-- b. If there is small table in outer query and big in inner query
--    better to use EXISTS
-- c. avoid using NOT IN if not sure about NULL values in the inner query, EXISTS is better because is safer
-- Example here

-- profile: 1 million rows
-- status_lookup: 10 rows
SELECT p.id, p.nick_name
FROM profile p
WHERE p.status_id IN (
  SELECT s.id FROM status_lookup s WHERE s.active = true
);

-- selected_users: 1000 rows
-- orders: 10 million rows
SELECT u.id, u.nick_name
FROM selected_users u
WHERE EXISTS (
  SELECT 1
  FROM orders o
  WHERE o.user_id = u.id AND o.created_at > CURRENT_DATE - INTERVAL '1 year'
);

-- 12 RULE - USE EXISTS instead of DISTINCT clause
-- When joining table with one to many relationships and trying to get the DISTINCT values
-- try to use EXISTS instead of DISTINCT clause.
-- It will use way less percent of CPU then with DISTINCT clause.
-- Example here
-- Bad:
SELECT DISTINCT u.id
FROM users u
JOIN orders o ON o.user_id = u.id;

-- Good:
SELECT u.id
FROM users u
WHERE EXISTS (
  SELECT 1 FROM orders o WHERE o.user_id = u.id
);

-- 13 RULE - Use analytical functions like OVER if need to retrieve for example total by month and other data
-- at ones
--
-- When you want to get, in a single query:
--    Detailed data (e.g., each individual order)
--    And aggregates (e.g., monthly total, number of orders, etc.)
--  Regular aggregate functions (GROUP BY) don't allow this — because they aggregate rows and remove the detail.

-- Example here
SELECT
  o.id,
  o.customer_id,
  o.created_at,
  o.amount,
  SUM(o.amount) OVER (PARTITION BY DATE_TRUNC('month', o.created_at)) AS total_by_month
FROM orders o;
-- The table orders has the following data:
--| id | customer\_id | created\_at | amount |
--| -- | ------------ | ----------- | ------ |
--| 1  | 101          | 2023-08-01  | 100    |
--| 2  | 101          | 2023-08-05  | 150    |
--| 3  | 102          | 2023-08-03  | 200    |
--| 4  | 101          | 2023-09-01  | 50     |
--| 5  | 103          | 2023-09-10  | 300    |

-- Results:
--| id | customer\_id | created\_at | amount | total\_by\_month |
--| -- | ------------ | ----------- | ------ | ---------------- |
--| 1  | 101          | 2023-08-01  | 100    | 450              |
--| 3  | 102          | 2023-08-03  | 200    | 450              |
--| 2  | 101          | 2023-08-05  | 150    | 450              |
--| 4  | 101          | 2023-09-01  | 50     | 350              |
--| 5  | 103          | 2023-09-10  | 300    | 350              |


-- 14 RULE - Use Delete if need to recover back data, but it slow
--           otherwise if no data  will be needed us TRUNCATE is way faster
--           because it's not store UNDO information in the database to roll it back



-- HINT
-- INDEX scan /*+ IndexScan(profile) */
-- This is just a suggestion for the PostgreSQL planner to use
-- it will not be mandatory to use it like other databases like Oracle for example
-- to force the planner to use the index, but it is just in testing and developing purposes
-- is to use SET enable_seqscan = off;

-- FULL scan
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
/*+ IndexScan(profile) */  SELECT p.id, p.nick_name -- planner automatically will use seq scan if it is the best one
                           FROM profile AS p
                           WHERE p.nick_name LIKE 'New%';

-- Index scan even with worse performance
SET enable_seqscan = off;
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.nick_name LIKE 'New%';


-- For the VACUUM command need to increase shared size, by default it's 64Mb
-- docker run -itd --shm-size=1g postgres

-- or in docker-compose:

-- db:
--   image: "postgres:11.3-alpine"
--   shm_size: 1g
VACUUM ANALYZE public.profile;
-- For tables statistics
SELECT * FROM pg_stat_all_tables WHERE schemaname = 'public' AND relname = 'profile';
-- For specific columns statistics in a table
SELECT * FROM pg_stats WHERE schemaname = 'public' AND tablename = 'profile';
-- For index statistics
SELECT * FROM pg_stat_all_indexes WHERE schemaname = 'public' AND relname = 'profile';






-- to add data to db for testing
do $$
    declare
 		i int;
new_p varchar;
begin
    for i in 2000..10000000
		loop
		new_p = CONCAT('New', i);
insert into profile (id, created_at, nick_name)
values (i,	'2023-11-14 17:13:12.676443',	new_p);
end loop;
end $$;


