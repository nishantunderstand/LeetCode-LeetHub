class Solution {
    public int[] sortArray(int[] nums) {
        return defaultMethod(nums);
    }

    // Sunday, November 17, 2024 7:55:19 PM
    // T.C - O(n^2/nlogn/n/√n/logn/1) | S.C - O(n/1/HeightOfTree)
    public int[] defaultMethod(int[] nums){
        Arrays.sort(nums);
        return nums;
    }
}