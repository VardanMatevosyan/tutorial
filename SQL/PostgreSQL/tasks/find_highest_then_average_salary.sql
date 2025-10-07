-- Find the highest salary from the Employee table than average salary.

-- +----+-------+--------+---------------+
-- | id | name  | salary | department_id |
-- +----+-------+--------+---------------+
-- | 1  | Ivan  | 1000.1234 | 1           |
-- | 2  | Anna  | 1500.1234 | 1           |
-- | 3  | Oleg  | 2000.1234 | 2           |
-- | 4  | Maria | 2200.1234 | 2           |
-- | 5  | David | 2000.5678 | 2           |
-- +----+-------+--------+---------------+

-- Result:
--  "Oleg"  2000.1234
--  "Maria"	2200.1234
--  "David"	2000.5678

-- Comparison: Window Function vs Scalar Subquery
-- |=================|=================================================|========================================|
-- | Aspect          | Window Function (OVER())                        | Scalar Subquery ((SELECT AVG...))      |
-- |-----------------|-------------------------------------------------|----------------------------------------|
-- | Readability     | More verbose, good if you need avg in output    | Cleaner, shorter, easier to read       |
-- | Performance     | Might compute value per row (optimizer helps)   | Usually computed once, very efficient  |
-- | Flexibility     | Can extend to partitions, multiple calculations | Limited — just one scalar value        |
-- | Best use case   | When you want to show avg alongside rows        | When you just filter vs avg            |

-- Example 1: Using Scalar Subquery (SELECT AVG(salary) FROM employee)
-- 📊 Pros:
-- Simpler and more readable.
-- Optimizers usually compute the subquery once (not per row).
-- Often slightly more efficient for this simple case.
-- ⚠️ Cons:
-- Less flexible if you later need per-group comparisons.
SELECT name, salary FROM employee
WHERE salary > (SELECT AVG(salary) FROM employee);

-------------------------------------------------------------------------------------

-- Example 2: Using Window Function AVG() OVER()
-- 📊 Pros:
-- Flexible (can compare to row-level aggregates, partitions, etc.).
-- Good if you want the average alongside each row.
-- ⚠️ Cons:
-- More verbose if you only need the filter.
-- The optimizer might compute the window function for all rows, even if only some rows are needed.
SELECT name, salary
FROM (SELECT name, salary, AVG(salary) OVER() AS avg_salary
      FROM employee) e
WHERE salary > avg_salary;





