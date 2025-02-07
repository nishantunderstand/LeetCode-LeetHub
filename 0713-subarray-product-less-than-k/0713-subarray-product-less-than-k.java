class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Dynamic Window / Caterpillar
        int windowProd=1;
        int startIdx=0;
        int cnt = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            windowProd *=nums[i];
            // Shrink the Window if product exceed k 
            while(windowProd>=k && startIdx<=i){ 
                windowProd /= nums[startIdx];
                startIdx++;
            }
            cnt+=(i-startIdx+1);           
        }
        return cnt;
    }
}