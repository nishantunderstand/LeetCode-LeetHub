-- Sunday, July 27, 2025 8:59:36 PM
-- LeetCode : 182


/**
-- Group By + Having Approach
SELECT email
FROM Person
GROUP BY email
HAVING COUNT(*)>1
ORDER BY email;

*/


-- Joins
SELECT DISTINCT p1.email
FROM Person p1, Person p2
WHERE p1.email = p2.email AND p1.id != p2.id
ORDER BY p1.email;