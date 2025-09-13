// Leetcode : 1979
class Solution {

    public int findGCD(int[] nums) {
        if(nums==null || nums.length==0){ 
            throw new IllegalArgumentException("Array is Empty");
        }
        return findEuclidianGCD(nums);
    }


    // Saturday, September 13, 2025 10:16:21 PM
    // Time Complexity:O(n*log(min(nums))) | Space Complexity:O(log(min(nums))
    public int findEuclidianGCD(int[] nums) {
        int small = Integer.MAX_VALUE;
        int larger = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            small = Math.min(small, nums[i]);
            larger = Math.max(larger, nums[i]);
        }
        //return euclidGCD(small, larger); // Valid 
        return euclidGCD(Math.abs(larger), Math.abs(small)); // Valid
        // Modulus Operator Work with Negative element as well.
    }

    // Time Complexity:O(log(min(nums))) | Space Complexity:O(log(min(nums))
    public int euclidGCD(int a, int b) {
        if (b == 0) { // Base Case
            return a;
        }
        return euclidGCD(b,a%b);
    }
}