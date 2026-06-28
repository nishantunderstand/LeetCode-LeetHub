// LeetCode : 930
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return bruteForce(nums,goal);
    }

    // Sunday, June 28, 2026 1:48:28 PM
	// TC : O(n^2) | SC : O(1)
    private int bruteForce(int[] nums, int goal) {
        int cnt = 0;
        for(int start=0;start<nums.length;start++){
            int csum  = 0;
            for(int end=start;end<nums.length;end++){
                csum += nums[end];
                if(csum==goal) cnt++;
            }   
        }
        return cnt;
    }
}