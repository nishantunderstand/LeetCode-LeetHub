-- LeetCode : 176
-- Saturday, April 19, 2025 10:02:43 PM

/**
❌ Rejected Approach 
SELECT salary AS SecondHighestSalary
FROM Employee e 
ORDER BY salary DESC
LIMIT 1 OFFSET 1;

❌ Rejected Approach 
SELECT DISTINCT salary AS SecondHighestSalary
FROM Employee e 
ORDER BY salary DESC
LIMIT 1 OFFSET 1;

✅ Accepted Approach
SELECT (
    SELECT DISTINCT e.salary
    FROM Employee e
    ORDER BY e.salary DESC 
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;



-- Case : Only One Unique Salary
-- Case : All Salaries Are the Same
-- Case : Handle All Edge Case 
-- SubQuery Approach

✅ Accepted Approach
SELECT MAX(e.salary) AS SecondHighestSalary
FROM Employee e
WHERE e.salary < (SELECT MAX(salary) FROM Employee);
*/


-- Inner Join Approach
SELECT MAX(e1.salary) AS SecondHighestSalary
FROM Employee e1 INNER JOIN Employee e2
ON e1.salary < e2.salary;
