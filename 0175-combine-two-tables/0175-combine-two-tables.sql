-- Monday, February 17, 2025 12:59:41 PM
-- LeetCode : 175

SELECT 
    p.firstName,
    p.lastName,
    a.city,
    a.state 
FROM Person p
LEFT JOIN Address a 
    ON p.personId = a.personId
ORDER BY firstName;
