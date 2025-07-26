-- Saturday, July 26, 2025 9:58:28 PM
-- LeetCode : 185

-- Group By Only
SELECT 
d.name AS Department,
e1.name AS Employee,
e1.salary AS Salary
FROM Employee e1
JOIN Department d ON e1.departmentId = d.id
LEFT JOIN Employee e2 ON e1.departmentId = e2.departmentId AND e2.salary>e1.salary
GROUP BY e1.name, e1.salary,e1.departmentId,d.name
HAVING COUNT(DISTINCT e2.salary)<3
ORDER BY d.name, e1.salary DESC;


/**
-- WINDOW Function MySQL 8.0
SELECT 
d.name AS Department,
e1.name AS Employee,
e1.salary AS Salary
FROM Employee e1
JOIN Department d ON e1.departmentId = d.id
ORDER BY d.name, e1.salary DESC;
*/