-- LeetCode : 181
-- Saturday, April 19, 2025 10:41:46 PM

SELECT e.name AS Employee 
FROM Employee e
-- JOIN Employee m ON e.id  = m.managerId
JOIN Employee m ON m.id  = e.managerId
WHERE e.salary > m.salary;