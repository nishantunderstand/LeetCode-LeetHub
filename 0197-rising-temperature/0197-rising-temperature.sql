-- Sunday, July 27, 2025 10:39:08 PM
-- LeetCode : 197

/**
-- REJECTED APPROACH
-- Date is Not Always Incresing 
SELECT w2.id 
FROM Weather w1
JOIN Weather w2 ON w1.id = w2.id-1
WHERE w1.temperature<w2.temperature;

-- ACCEPTED APPROACH
SELECT w2.id 
FROM Weather w1
JOIN Weather w2 ON w2.recordDate = DATE_ADD(w1.recordDate,INTERVAL 1 DAY)
WHERE w1.temperature<w2.temperature;

*/

SELECT w2.id 
FROM Weather w1
JOIN Weather w2 ON w2.recordDate > w1.recordDate
WHERE DATEDIFF(w2.recordDate,w1.recordDate)=1 AND w1.temperature<w2.temperature;
