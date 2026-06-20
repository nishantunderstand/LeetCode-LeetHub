class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int odd = 1;
        while(pos<nums.length && odd <nums.length){
            if(nums[pos]>0) pos+=2;
            else if(nums[neg]<0) neg+=2;
            else{
                swap(nums,pos,neg);
                pos+=2;
                neg+=2;
            }
        }
        return nums;        
    }

    
}
// Sunday, June 14, 2026 1:18:28 AM
// TC : O(2^nnlognk) | SC : O(2^n1logkh)
// LeetCode : 2149