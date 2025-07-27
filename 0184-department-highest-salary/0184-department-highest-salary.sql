-- Sunday, July 27, 2025 3:36:57 PM
-- LeetCode : 184


/**
-- Equi Join + Window Function
SELECT 
    dep.name AS Department,
    emp.name AS Employee,
    emp.salary AS Salary
FROM (
    SELECT *, RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) AS rnk FROM employee 
    ) emp
JOIN Department dep
ON emp.departmentId = dep.id
WHERE emp.rnk=1;
*/



SELECT 
    dep.name AS Department,
    emp.name AS Employee,
    emp.salary AS Salary
FROM Employee emp
JOIN Department dep 
ON emp.departmentId = dep.id
WHERE emp.salary = (
    SELECT MAX(Salary)
    FROM Employee
    WHERE departmentId = emp.departmentId
);
