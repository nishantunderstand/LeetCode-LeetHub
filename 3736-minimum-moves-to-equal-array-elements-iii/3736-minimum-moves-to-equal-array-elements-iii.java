// LeetCode : 3376
// Wednesday, November 4, 2026 12:54:42 PM    
// TC : O(n) | SC : O(1)
class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(num,max);
        }
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            cnt += (max-nums[i]);
        }
        return cnt;
    }
}