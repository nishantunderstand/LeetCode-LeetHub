class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return dynamicWindow(nums,k);
        //return hashMapApproach(nums,k);
    }

    // PENDING 
    public int hashMapApproach(int[] nums, int k) {
        HashMap<Long,Integer> hm = new HashMap<>();
        hm.put(1L,1);
        long prod = 1;
        int cnt=0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            prod *=nums[i];

        }
        return cnt;
    }

    // Friday, February 7, 2025 11:25:11 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int dynamicWindow(int[] nums, int k) {
        // Dynamic Window
        int windowProd=1;
        int startIdx=0;
        int cnt = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            windowProd *=nums[i];
            // Shrink the Window if product exceed k 
            while(windowProd>=k && startIdx<=i){  //<-- Out of Bound
                windowProd /= nums[startIdx];
                startIdx++;
            }
            cnt+=(i-startIdx+1);  // Why are we counting like this ?          
        }
        return cnt;
    }

}