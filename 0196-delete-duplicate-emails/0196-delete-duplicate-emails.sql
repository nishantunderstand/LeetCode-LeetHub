-- Sunday, July 27, 2025 2:52:22 PM
-- LeetCode : 196

/**
❌ Rejected Approach
DELETE FROM Person
WHERE id NOT IN (
    SELECT MIN(id) AS id
    FROM Person
    GROUP BY email
);
-- You can't specify target table 'Person' for update in FROM clause

-- When you perform MIN(id) IN Output Column Name will become MIN(id).
-- That's Why Alias is Required
*/

-- ✅ Accepted Approach

DELETE FROM PERSON
WHERE id NOT IN (
    SELECT id FROM (
        SELECT MIN(id) AS id FROM Person GROUP BY email
    ) AS temp    
);

-- Can we use Delete with Group By ?
-- Can we use having without Group By ?
-- Group By is meant to Aggegaration Applciable to Select Only