# Write your MySQL query statement below
-- LeetCode : 175
-- MYSQL
-- Monday, February 17, 2025 12:59:41 PM

SELECT 
    p.firstName,
    p.lastName,
    a.city,
    a.state 
FROM Person p
LEFT JOIN Address a 
    ON p.personId = a.personId
ORDER BY firstName;
