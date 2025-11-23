// LeetCode : 3
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return slidingWindowPattern(s);
    }

    // Tuesday, September 16, 2025 9:47:21 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int slidingWindowPattern(String s) {
        Set<Character> seen = new HashSet<>();
        int windowStart = 0, maxLen = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);
            // If Duplicate Found , Shrink 
            while (seen.contains(currentChar)) {
                seen.remove(s.charAt(windowStart));
                windowStart++;
            }
            seen.add(currentChar);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }
}