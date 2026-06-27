// Leetcode : 485
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //return bruteForce(nums);
        return slidingwindow(nums);
    }

    // Saturday, June 27, 2026 11:39:37 PM
	// TC : O(n) | SC : O(1)
    private int slidingwindow(int[] nums){
        int left = 0;
        int ans = -1;
        int window = 0;
        for(int right=0;right<nums.length;right++){
            // Add element nums[right] to window
            window += nums[right];

            // while condition not met
                // do some logic to remove left from window and left++

            while(right-left+1!=window){
                window -= nums[left];
                left++;
            }

            // update the answer
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }

    // Friday, December 27, 2024 3:06:47 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private int bruteForce(int[] nums) {
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
}
// <img src="Flatten2D1.png">
// <img src="Flatten2D2.png">
// https://www.youtube.com/watch?v=9g1dV8UuYiM