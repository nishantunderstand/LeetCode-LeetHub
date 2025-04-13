// Leetcode : 16
class Solution {
    public int threeSumClosest(int[] nums, int target) {        
        return twoPointerApproach(nums,target);
    }

    // Saturday, April 12, 2025 6:45:03 PM
    // Time Complexity:O(nlogn)+ O(n^2) | Space Complexity:O(1)
    public int twoPointerApproach(int[] nums, int target) {
        int len = nums.length;
        if (nums == null || len < 3) return 0;
        int closestSum1 = Integer.MAX_VALUE; //<--
        int closestSum2 = Integer.MIN_VALUE; //<--
        int closestSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //<--

            int lo = i + 1;
            int hi = len - 1;
            while (lo < hi) {
                int csum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(csum - target) < Math.abs(closestSum - target)) {closestSum = csum;}

                if (csum < target) lo++;
                else if (csum > target) hi--;
                else {return csum;}
            }
        }
        return closestSum;
    }
}