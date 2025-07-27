-- Sunday, July 27, 2025 2:38:42 PM
-- LeetCode : 183

SELECT name AS Customers
FROM Customers 
WHERE id NOT IN (
    SELECT customerId FROM Orders
);
