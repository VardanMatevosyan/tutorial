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
-- If there is insufficient data, an sequence scan will be used even if there is index for the column
-- BAD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id + 5000000 > 115;

-- GOOD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name
FROM profile AS p
WHERE p.id > 5000215;



-- 4 RULE - Avoid using DATE_TRUNC function to campare for example compare if it's the first day of the month
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
-- BAD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name, p.created_at
FROM profile AS p
WHERE p.nick_name IS NULL;

-- GOOD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name, p.created_at
FROM profile AS p
WHERE p.nick_name = 'NOT_PRESENT';


-- 7 RULE - Avoid using functions for column with index
-- BAD query
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT p.id, p.nick_name, p.created_at
FROM profile AS p
WHERE SUBSTR(p.nick_name, 1, 3) = 'Var';

-- Insted use index based functions
-- GOOD query with index based function
CREATE INDEX substring_function_inx ON profile(SUBSTR(nick_name, 1, 3));






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


