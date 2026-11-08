// LeetCode : 128
// Sunday, November 8, 2026 7:57:27 PM    
// TC : O(nlogn+n) | SC : O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        
        Arrays.sort(nums);
        
        int maxLen = 1;
        int len = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                continue; // Ignore Duplicate
            }
            else if(nums[i]==nums[i-1]+1){ // Greater than 1
                len++;                
            }else{ // Mismatch || Reset It 
                len = 1;
            }
             maxLen = Math.max(maxLen,len); // Best Approach
        }
        return maxLen;
    }
}