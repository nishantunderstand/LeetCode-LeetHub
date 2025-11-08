// Leetcode : 713
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return dynamicSlidingWindow(nums,k);
        //return hashMapApproach(nums,k);
    
    }

    // Saturday, November 8, 2025 8:54:06 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int dynamicSlidingWindow(int[] nums, int k) {
        // Dynamic Window
        int windowProd=1;
        int startIdx=0;
        int cnt = 0;
        int len = nums.length;
        for(int windowEnd=0;windowEnd<len;windowEnd++){
            windowProd *=nums[windowEnd];
            // Shrink the Window if product exceed k 
            while(windowProd>=k && startIdx<=windowEnd){  //<-- Out of Bound, Overshoot 
                windowProd /= nums[startIdx];
                startIdx++;
            }
            cnt+=(windowEnd-startIdx+1);   //<--
        }
        return cnt;
    }



    
    // A HashMap is typically useful for prefix sum problems, where we check:
    // Why not HashMap? Products are multiplicative → cannot use prefix sum hashmap directly.
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

}