# Write your MySQL query statement below
-- LeetCode : 175
-- Monday, February 17, 2025 12:59:41 PM

SELECT 
    Person.firstName,
    Person.lastName,
    Address.city,
    Address.state 
FROM Person
LEFT JOIN Address  
    USING (personId);

