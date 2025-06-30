-- Monday, June 30, 2025 7:47:51 PM
-- LeetCode : 1148

SELECT DISTINCT
    v.author_id AS id
FROM Views v
WHERE
v.author_id = v.viewer_id
ORDER BY id;




