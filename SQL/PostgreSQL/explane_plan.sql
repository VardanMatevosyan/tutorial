SET enable_seqscan TO off; -- bad if data is less then 1%
EXPLAIN (ANALYZE, COSTS, VERBOSE, BUFFERS, FORMAT JSON)
SELECT c.phone_number, p.nick_name
FROM profile AS p
         inner JOIN contact AS c ON c.profile_id = p.id;

SET enable_seqscan TO off; -- bad if data is less then 1%
EXPLAIN ANALYZE SELECT * FROM perches.orders WHERE customer_email = 'email@gmail.com'


ANALYZE VERBOSE perches.orders;
SELECT * FROM perches.orders WHERE order_status = 'ORDER_CANCELED';
EXPLAIN ANALYZE SELECT * FROM perches.orders WHERE customer_email = 'email@gmail.com'
EXPLAIN ANALYZE SELECT * FROM perches.orders WHERE order_status = 'ORDER_CANCELED';
EXPLAIN SELECT * FROM perches.orders;
EXPLAIN ANALYZE SELECT * FROM perches.orders;


-- get statistics data - this is view tables that collect the data from the pg_statistic table
-- and it used to create the explained plan in PostgreSQL
-- the ANALYZE creates the statistics for it
SELECT
    pg_class.relname AS table_name,
    pg_stats.attname AS column_name,
    pg_stats.n_distinct AS distinct_values,
    pg_stats.most_common_vals AS most_common_values,
    pg_stats.most_common_freqs AS most_common_freq,
    pg_stats.histogram_bounds AS histogram_bounds,
    pg_attribute.attlen
FROM
    pg_stats
        JOIN
    pg_class ON pg_stats.tablename = pg_class.relname
        JOIN
    pg_attribute ON pg_attribute.attname = pg_stats.attname
WHERE
    pg_stats.tablename IN ('orders')
ORDER BY
    relname,
    pg_stats.attname;




