-- LeetCode : 176
-- Saturday, April 19, 2025 10:02:43 PM

/**
-- REJECTED APPROACH
SELECT salary AS SecondHighestSalary
FROM Employee e 
ORDER BY salary DESC
LIMIT 1 OFFSET 1;

-- REJECTED APPROACH 
SELECT DISTINCT salary AS SecondHighestSalary
FROM Employee e 
ORDER BY salary DESC
LIMIT 1 OFFSET 1;

-- ACCEPTED APPROACH
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

-- ACCEPTED APPROACH
SELECT MAX(e.salary) AS SecondHighestSalary
FROM Employee e
WHERE e.salary < (SELECT MAX(salary) FROM Employee);


-- Inner Join Approach
SELECT MAX(e1.salary) AS SecondHighestSalary
FROM Employee e1 INNER JOIN Employee e2
ON e1.salary < e2.salary;

*/

-- Window Function rank
SELECT 
    MAX(salary) AS SecondHighestSalary 
FROM 
    (
    SELECT 
        salary,
        DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
    FROM Employee
    ) ranked
Where rnk=2;
-- If there is no rank = 2, the subquery returns no rows.

