class Solution {
    public int maximumProduct(int[] nums) {
        if(nums==null || nums.length<3) return 0;
        Arrays.sort(nums);
        int len = nums.length; 
        int option1 = nums[len-1] * nums[len-2] * nums[len-3];
        int option2 = nums[0] * nums[1] * nums[len-1];
        return Math.max(option1, option2);
    }
}