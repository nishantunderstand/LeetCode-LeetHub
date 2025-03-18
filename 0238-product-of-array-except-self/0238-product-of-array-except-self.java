// LeetCode 238
class Solution {
    public int[] productExceptSelf(int[] nums) {    
        return prefixAndSuffixApproach(nums);
        //return bruteForceApproach(nums);
        //return byDivision(nums);
    }

    // [-1,1,0,-3,3]
    // Failed If Zero is Present in the Array
    // Time Complexity:O(n) | Space Complexity:O(n)
    private int[] byDivision(int[] nums) {
        int total = 1;
        for(int num:nums){
            total*=num;
        }
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                res[i]=total/nums[i]; //<--
            }            
        }
        return res;
    }

    // TLE
    // Time Complexity:O(n^2) | Space Complexity:O(1)
    private int[] bruteForceApproach(int[] nums) {
        // Create a result Array
        int[] res = new int[nums.length];
        // Calcuate | Except Itself
        for(int i =0;i<nums.length;i++){
            int prod=1;
            for(int j=0;j<nums.length;j++){
                if(i==j) continue;
                prod*=nums[j];
            }
            res[i]=prod;
        }

        // Return
        return res;
    }

    // Tuesday, March 18, 2025 8:04:59 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private int[] prefixAndSuffixApproach(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0]=1;
        // Start From 2 Location From Start
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }

        suffix[nums.length-1]=1;
        // Start from 2 Location From end
        for(int i=nums.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i+1];
        }
        int[] ans = new int[nums.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }    
}