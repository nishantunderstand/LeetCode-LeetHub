class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        return dynamicSlidingWindow(target, nums);
        //return dynamicSlidingWindowFOR(target, nums);
    }

    // Friday, February 7, 2025 10:05:46 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int dynamicSlidingWindow(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];
            while (windowSum >= target) {
                minLen = Math.min(minLen, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart]; // <--
                windowStart++; // <--
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // Friday, February 7, 2025 10:05:46 PM
    // Time Complexity: O(n) | Space Complexity: O(1)
    public int dynamicSlidingWindowFOR(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        int windowSum = 0;

        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            // Convert while loop into for loop
            for (; windowSum >= target; startIdx++) {
                minLen = Math.min(minLen, i - startIdx + 1);
                windowSum -= nums[startIdx];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // WHY TLE??
    public int minSubArrayLenTLE(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int csum = 0;
            for (int j = i; j < nums.length; j++) {
                csum += nums[j];
                if (csum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;// <-- HERE YOU ARE NOT DECREASING THE LENGTH
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}