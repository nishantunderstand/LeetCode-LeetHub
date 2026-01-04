// LeetCode 2016
class Solution {
    public int maximumDifference(int[] nums) {
        return bruteForce(nums);
    }

    // Friday, February 14, 2025 8:15:53 PM
    // Time Complexity:O(n^2) | Space Complexity:O(1)
    public int bruteForce(int[] nums) {
        int len = nums.length;
        int max = -1; 

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(nums[j]>nums[i]){
                    int csum = nums[j]-nums[i];
                    max = Math.max(max,csum);
                }
            }
        }
        return max;
    }
    
    // FAILED
    public int bruteForceFAILED(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int csum = nums[j]-nums[i];
                max = Math.max(max,csum);
            }
        }
        return max==Integer.MIN_VALUE?-1:max;
    }

}