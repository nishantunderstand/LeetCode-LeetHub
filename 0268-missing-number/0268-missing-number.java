class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int totalsum = n*(n+1)/2;
        for(int i=0;i<nums.length;i++){
            totalsum-=nums[i];
        }
        return totalsum;
        
    }
}

// https://leetcode.com/problems/missing-number/solutions/69786/3-different-ideas-xor-sum-binary-search-java-code