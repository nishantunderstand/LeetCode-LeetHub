-- Sunday, August 3, 2025 2:16:53 PM
-- LeetCode : 1667
SELECT 
user_id,
CONCAT(
    UPPER(LEFT(name,1)),
    LOWER(SUBSTRING(name,2))
) AS name
FROM Users
ORDER BY user_id;


/**
LOWER()
UPPER()
PROPERCASE | SENTENCE CASE NO
*/

-- How to Handle Multi-Word Name ?