// Leetcode : 485
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        return bruteForce(nums);
    }

    // Friday, December 27, 2024 3:06:47 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int bruteForce(int[] nums) {
        int maxOne=0;
        int currOne=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                currOne++;
            }else{
                maxOne=Math.max(currOne,maxOne);
                currOne=0; //<--
            }                     
        }
        maxOne=Math.max(currOne,maxOne);  //<--
        return maxOne;
    }

    // <img src="Flatten2D1.png">
    // <img src="Flatten2D2.png">
}