-- Monday, June 30, 2025 8:02:01 PM
-- LeetCode : 1683

SELECT tw.tweet_id
FROM Tweets tw
WHERE CHAR_LENGTH(tw.content) >15
ORDER BY tw.tweet_id;

/** Correct AS MYSQL 

SELECT tw.tweet_id
FROM Tweets tw
WHERE LENGTH(tw.content) >15
ORDER BY tw.tweet_id;
*/