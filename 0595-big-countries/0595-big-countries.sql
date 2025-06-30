-- Monday, June 30, 2025 7:43:20 PM
-- LeetCode : 595

SELECT 
    w.name,
    w.population,
    w.area
FROM World w
WHERE 
w.area >= '3000000'
OR w.population >= '25000000'
ORDER BY w.name ASC;
