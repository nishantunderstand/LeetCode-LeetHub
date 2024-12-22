class Solution {
    public int findKthLargest(int[] nums, int k) {
        return arrayApproach(nums,k);
    }

    // Sunday, December 22, 2024 4:02:40 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(1)
    public int arrayApproach(int[] nums, int k) {
        int n = nums.length;
        if(k>n){
            return 0;
        }
        Arrays.sort(nums);
        return nums[n-k];
    }
}