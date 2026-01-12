-- Find the second highest salary from the Employee table.
-- If there is no second highest salary, then the query should return null.

-- +----+-------+--------+---------------+
-- | id | name  | salary | department_id |
-- +----+-------+--------+---------------+
-- | 1  | Ivan  | 1000.1234 | 1           |
-- | 2  | Anna  | 1500.1234 | 1           |
-- | 3  | Oleg  | 2200.1234 | 2           |
-- | 4  | Maria | 2200.1234 | 2           |
-- | 5  | David | 2000.5678 | 2           |
-- +----+-------+--------+---------------+

-- Result: 2000.5678.

-------------------------------------------------------------------------------------
-- ======================================================================================
-- Method                          | No Index     | With Index (ASC/DESC)       | Best For
-- -------------------------------|--------------|-----------------------------|------------------------------
-- MAX() + Subquery               | O(N)         | O(log N + c)                   | 2nd highest (distinct), NULL-safe
-- DISTINCT + ORDER BY + OFFSET   | O(N log N)   | O(k log N) or O(N)         | Top-N distinct (if skip scan available)
-- DENSE_RANK() OVER (...)        | O(N log N)   | O(N log N) (slight constant improvement) | Flexible ranking with ties
-- ======================================================================================
-- O(log N + c), c = small constant (rows examined after max)
-- For option with DISTINCT only in MySQL 8.0+, PG 13+ with skip/loose index scan; otherwise O(N)

-- Example 1:
-- Using MAX() aggregation function and Sub-Query
-- MAX works even with number of digits after the decimal point.
-- Without index it will be O(N). Which is better than O(N log N) other solutions.
SELECT MAX(salary) FROM employee
WHERE salary < (SELECT MAX(salary) from employee);

-------------------------------------------------------------------------------------

-- Example 2:
-- Using  DISTINCT + ORDER BY + OFFSET
-- With index the best to use it with DESC index.
SELECT DISTINCT salary FROM employee
ORDER BY salary DESC
OFFSET 1
LIMIT 1;

-------------------------------------------------------------------------------------

-- Example 3:
-- Using DENSE_RANK() OVER (ORDER BY salary DESC)
-- Better to use it with DESC index and only more flexible than OFFSET+LIMIT are needed.
SELECT salary
FROM (SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS place FROM employee) AS emp
WHERE place = 2;


