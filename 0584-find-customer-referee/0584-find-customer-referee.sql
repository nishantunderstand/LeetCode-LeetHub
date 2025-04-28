# Write your MySQL query statement below
# Leetcode : 584


/** Approach 1
SELECT c.name
FROM Customer c
WHERE c.referee_id IS NULL OR c.referee_id <> 2;
*/

-- Approach 2
SELECT c.name
FROM Customer c
WHERE c.referee_id IS NULL OR c.referee_id != 2;