-- Find the second highest salary from the Employee table.
-- If there is no second highest salary, then the query should return null.

-- +----+-------+--------+---------------+
-- | id | name  | salary | department_id |
-- +----+-------+--------+---------------+
-- | 1  | Ivan  | 1000.1234 | 1           |
-- | 2  | Anna  | 1500.1234 | 1           |
-- | 3  | Oleg  | 2000.1234 | 2           |
-- | 4  | Maria | 2200.1234 | 2           |
-- | 5  | David | 2000.5678 | 2           |
-- +----+-------+--------+---------------+

-- Result: 2000.5678.

-------------------------------------------------------------------------------------
-- ======================================================================================
-- Method           | No Index   | ASC Index | DESC Index | Best Use
-- -----------------|------------|-----------|------------|------------------------------
-- MAX()+Subquery   | O(N)       | O(log N)  | O(log N)   | Simple, top-1/2 only
-- ORDER BY+OFFSET  | O(N log N) | Faster    | Very fast  | General top-N
-- DENSE_RANK()     | O(N log N) | Faster    | Very fast  | Top-N with ties
-- ======================================================================================

-- Example 1:
-- Using MAX() aggregation function and Sub-Query
-- MAX works even with number of digits after the decimal point.
-- Without index it will be O(N). Which is better than O(N log N) other solutions.
SELECT MAX(salary) FROM employee
WHERE salary < (SELECT MAX(salary) from employee);

-------------------------------------------------------------------------------------

-- Example 2:
-- Using ORDER BY + OFFSET
-- With index the best to use it with DESC index.
SELECT salary FROM employee
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


