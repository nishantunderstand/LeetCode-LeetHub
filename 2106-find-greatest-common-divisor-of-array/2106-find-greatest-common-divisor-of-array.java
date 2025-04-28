// Leetcode : 1979
class Solution {
    public int findGCD(int[] nums) {
        int small = Integer.MAX_VALUE;
        int larger = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            small = Math.min(small, nums[i]);
            larger = Math.max(larger, nums[i]);
        }
        return euclidGCD(small, larger);
    }

    public int euclidGCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return euclidGCD(b % a, a);
    }
}