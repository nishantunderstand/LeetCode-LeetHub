// Leetcode : 189
class Solution {
    public void rotate(int[] nums, int k) {
       jugglingAlgo(nums,k);
    }

    // Monday, March 17, 2025 8:28:09 AM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private void jugglingAlgo(int[] nums, int k) {
        //Approach 1
        /**
        k=k%nums.length;
        if(k<0){
            k=k+nums.length;
        }
        */
        // Approach 2
        int n = nums.length;
        k = ((k % n) + n) % n;  //<--
        reverse(nums,0,nums.length-1-k);
        reverse(nums,nums.length-1-k+1,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    private void reverse(int[] arr, int i,int j){
        while(i<=j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}