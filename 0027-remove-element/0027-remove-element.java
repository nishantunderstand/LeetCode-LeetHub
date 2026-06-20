class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while(i<nums.length){
            if(nums[i]!=val){
                swap(nums,i,j);
                j++;
            }
            i++;
        }
        return j;
    }
    private void swap(int[] nums, int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}