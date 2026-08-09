// LeetCode : 128
// Sunday, August 9, 2026 10:58:36 PM
// TC : O(nlogn+n) | SC : O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        Arrays.sort(nums);
        int maxLen = 1;
        int currLen = 1;
        for(int i=1;i<nums.length;i++){
            // Duplicate will not contribute in result
            if(nums[i]==nums[i-1]){                
                continue;
            }else if (nums[i]==nums[i-1]+1){
                currLen++;                
            }else{
                maxLen = Math.max(maxLen,currLen);
                currLen = 1;
            }
        }  
        maxLen = Math.max(maxLen,currLen); 
        return maxLen; 
    }
}
