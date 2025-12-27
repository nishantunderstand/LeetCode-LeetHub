// LeetCode : 977
class Solution {
    public int[] sortedSquares(int[] nums) {
        //return streamApproach(nums);
        return twoPointerApproach(nums);
    }

    private int[] twoPointerApproach(int[] nums){
        int[] res = new int[nums.length];
        // Sqauring it 
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]*nums[i];
        }

        // Filling it 
        int head = 0;
        int tail = nums.length-1;        
        for(int i=nums.length-1;i>=0;i--){
            if(nums[tail] > nums[head]) res[i]=nums[tail--];
            else res[i] = nums[head++];
        }
        return res;
    }

    // Monday, December 22, 2025 9:55:47 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(n)
    public int[] streamApproach(int[] nums) {
        return Arrays.stream(nums)
        .map(n->n*n)
        .sorted()
        .toArray();
    }
}