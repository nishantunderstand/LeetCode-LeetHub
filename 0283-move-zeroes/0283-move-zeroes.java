class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        while(i<len && j<len){
                if(nums[i]==0){
                i++;
            }else{
                swap(nums,i,j);
                j++;
                i++;
            }
        }
    }
    public void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
// I cannot swap with End Element, As it is Unknown
// However i can use Dutch National Flag Algorithm, Know and Unknow Region Concept

/**
0 1 0 3 12


*/