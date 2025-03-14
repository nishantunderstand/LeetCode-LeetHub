class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(k<0){
            k=k+nums.length;
        }
        reverse (nums,0,nums.length-1-k);
        reverse(nums,nums.length-1-k+1,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    private void reverse(int[] arr, int x,int y){
        int i=x;
        int j=y;
        while(i<=j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}