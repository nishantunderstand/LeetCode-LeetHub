-- Saturday, July 26, 2025 10:40:47 PM
-- LeetCode : 620

SELECT *
FROM Cinema
WHERE description != 'boring'
AND id%2 = 1
ORDER BY rating DESC;