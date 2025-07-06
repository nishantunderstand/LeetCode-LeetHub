-- Leetcode : 1757
/** Normal Approach
SELECT 
    p.product_id
FROM Products p
WHERE p.low_fats='Y' AND 
    p.recyclable='Y'
ORDER BY product_id;
*/

SELECT product_id 
FROM 
(SELECT * FROM Products WHERE low_fats = 'Y')
Products
WHERE recyclable = 'Y'
ORDER BY product_id;