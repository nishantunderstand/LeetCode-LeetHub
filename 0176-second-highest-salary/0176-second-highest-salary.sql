# Write your MySQL query statement below
-- LeetCode : 176
-- Saturday, April 19, 2025 10:02:43 PM


-- Case : Only One Unique Salary
-- Case : All Salaries Are the Same
-- Case : Handle All Edge Case 

SELECT 
    MAX(e.salary) AS SecondHighestSalary
FROM 
    Employee e
WHERE 
    e.salary < (
        SELECT 
            MAX(salary) 
        FROM 
            Employee
    );


/**
SELECT (
    SELECT DISTINCT 
        e.salary
    FROM 
        Employee e
    ORDER BY 
        e.salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;


*/

