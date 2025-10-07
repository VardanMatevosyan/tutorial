
-- For simplicity, we will create a single table named `employee`
-- without foreign keys or additional constraints to department table.

CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary NUMERIC(10,4) NOT NULL,
    department_id INT NOT NULL
);

INSERT INTO employee (name, salary, department_id)
VALUES  ('Ivan', '1000.1234', 1),
        ('Anna', '1500.1234', 1),
        ('Oleg', '2000.1234', 2),
        ('Maria', '2200.1234', 2),
        ('David', '2000.5678', 2);