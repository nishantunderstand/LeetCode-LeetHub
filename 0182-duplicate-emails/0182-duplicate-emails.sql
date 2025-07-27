-- Sunday, July 27, 2025 8:59:36 PM
-- LeetCode : 182

SELECT email
FROM Person
GROUP BY email
HAVING COUNT(*)>1
ORDER BY email;