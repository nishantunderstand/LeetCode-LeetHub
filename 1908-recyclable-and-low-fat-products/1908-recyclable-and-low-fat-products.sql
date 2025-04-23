# Write your MySQL query statement below
-- Leetcode : 1757
SELECT 
    p.product_id
FROM Products p
WHERE p.low_fats='Y' AND 
    p.recyclable='Y'
ORDER BY product_id;