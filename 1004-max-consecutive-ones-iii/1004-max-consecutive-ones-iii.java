// Leetcode : 1004
class Solution {
    public int longestOnes(int[] nums, int k) {  
        return bruteForce(nums,k);          
        //return slidingWindowApproach(nums,k);       
    }

    // Longest SubArray with atMost k Zero 
    // Sunday, June 28, 2026 12:02:40 AM
	// TC : O(n^2) | SC : O(1)
    private int bruteForce(int[] nums,int k ){
        int maxLen = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int zeroCnt= 0;
            for(int j=i;j<n;j++){ //<--
                if(nums[j]==0) zeroCnt++;
                if(zeroCnt>k) break;
                maxLen = Math.max(maxLen,j-i+1);                
            }
        }
        return maxLen;
    }

    // Wednesday, May 14, 2025 11:44:13 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int slidingWindowApproach(int[] nums, int k) {        
        int zeroCnt=0,windowStart = 0,maxLen=0;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            if(nums[windowEnd]==0) zeroCnt++;
            while(zeroCnt>k){
                if(nums[windowStart]==0)zeroCnt--;                
                windowStart++;  //<-- // Always move windowStart forward
            }
            maxLen = Math.max(windowEnd-windowStart+1,maxLen);  //<--
        }
        return maxLen;       
    }
}