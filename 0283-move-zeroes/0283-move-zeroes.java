// Leetcode : 283
class Solution {
    public void moveZeroes(int[] nums) {
        //basedOnDutchNationalFlag(nums);
        //bySwapNotRelativeOrder(nums);
        nonZerotoStart(nums);
    }

    private void nonZerotoStart(int[] nums){
        int nonZeroLoc = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums,i,nonZeroLoc++);
            }
        }
    }

    // Correct But Not Required , Question Required is Different 
    private void bySwapNotRelativeOrder(int[] nums){
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            if(nums[i]==0){
                swap(nums,i,j);
                j--;
            }else{
                i++;
            }            
        }
    }

    // Saturday, February 15, 2025 12:41:47 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    // Relative Order is Maintained
    public void basedOnDutchNationalFlag(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        while (i < len && j < len) {
            if (nums[i] == 0) {
                i++;
            } else {
                swap(nums, i, j);
                j++;
                i++;
            }
        }
    }

    // Time Complexity:O(1) | Space Complexity:O(1)
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

// I cannot swap with End Element, As it is Unknown
// However i can use Dutch National Flag Algorithm, Know and Unknow Region Concept
/**
0 1 0 3 12
*/


// Related Leetcode : 75 