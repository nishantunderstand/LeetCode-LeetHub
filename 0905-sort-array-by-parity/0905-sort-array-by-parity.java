class Solution {

    public int[] sortArrayByParity(int[] nums) {
        // Two Way Partition
        int i = 0;
        int j = 0;
        // Even + Odd
        while(i<nums.length){
            if(nums[i]%2==0){
                swap(nums,i,j);
                j++;
            }
            i++;
        }
        return nums;
    }

    private void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
}