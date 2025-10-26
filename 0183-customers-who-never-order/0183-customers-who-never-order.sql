-- LeetCode : 183
-- Sunday, July 27, 2025 2:38:42 PM

/**
-- ACCEPTED APPROACH
SELECT name AS Customers
FROM Customers 
WHERE id NOT IN (
    SELECT customerId FROM Orders
);
*/



-- Join Approach
SELECT name AS Customers
FROM Customers cus
LEFT JOIN Orders od
ON cus.id = od.customerId
WHERE od.customerId IS NULL;

