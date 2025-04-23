// Leetcode : 268
class Solution {
    public int missingNumber(int[] nums) {        
        return mathApproach(nums);
        //return hashSetApproach(nums);
    }  

    private int hashSetApproach(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<n;i++){
            hs.add(nums[i]);
        }

        for(int i=0;i<=n;i++){
            if(!hs.contains(i)) return i;
        }
        return -1;     
    }



    // Wednesday, April 23, 2025 8:06:30 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int mathApproach(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int expectedSum = n*(n+1)/2;
        int actualSum = 0;
        for(int i=0;i<n;i++){
            actualSum += nums[i];
        }
        return expectedSum-actualSum;
        
    }
}

// https://leetcode.com/problems/missing-number/solutions/69786/3-different-ideas-xor-sum-binary-search-java-code