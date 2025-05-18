class Solution {
    public int jump(int[] nums) {
        return greedySolution(nums);
    }

    // Sunday, May 18, 2025 10:35:57 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int greedySolution(int[] nums) {
        int n = nums.length;

        if (n <= 1) return 0;
        if (nums[0] == 0) return -1;  //<--

        int jumps = 0;
        int currentEnd = 0;
        int maxReach = 0;

        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                if(maxReach == currentEnd) return -1;  //<--
                currentEnd = maxReach; //<--
            }
        }

        return currentEnd >= n - 1 ? jumps : -1;  //<--
    }

}