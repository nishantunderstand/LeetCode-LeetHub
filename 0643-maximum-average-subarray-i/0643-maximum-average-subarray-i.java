// LeetCode 643
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //return bruteForce(nums,k);
        return slidingWindowCaterpillar(nums,k);
        //return runningSum(nums,k);
    }
    // Postive & Negative
    // Friday, February 14, 2025 12:16:10 AM
    // Time Complexity:O(n) | Space Complexity:O(1)
    // Two Pass Solution // <--
    public double runningSum(int[] nums, int k) {
        int len = nums.length;
        if(nums==null || nums.length==0 || k>nums.length) return 0.0;
        double windowSum = 0; // <--
        for(int i=0;i<k;i++){
            windowSum+=nums[i];
        }
        double max = windowSum; //<---

        for(int windowEnd=k;windowEnd<nums.length;windowEnd++){
            windowSum += nums[windowEnd];
            windowSum -= nums[windowEnd-k]; //<--
            max = Math.max(max,windowSum);
        }
        return max/k; // <-- SOLVING AS NORMAL THen Dividing with k        
    }


    // Thursday, September 18, 2025 9:34:23 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    // One Pass Solution  // <--
    public double slidingWindowCaterpillar(int[] nums, int k) {        
        double max = Double.NEGATIVE_INFINITY; // <--
        
        int windowStart = 0;
        double windowSum = 0.0;
        
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum+=nums[windowEnd];
            if(windowEnd>=k-1){
                max = Math.max(max,windowSum/k);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        return max;        
    }

    // TLE 
    public double bruteForce(int[] nums, int k) {
        int len = nums.length;        
        //if(nums=0||len=0||k>len) return 0.0;
        double max = Double.NEGATIVE_INFINITY;
        for(int i=0;i<len;i++){
            double csum=0;
            int cnt=0;
            //for(int j=i;j<len && j+i<=k;j++){
            for(int j=i;j<len && j<i+k;j++){
                csum+=nums[j];
                cnt++;
            }
            if(cnt==k){
                max = Math.max(max,csum/k);
            }            
        }
        return max == Double.MIN_VALUE?0.0:max;        
    }
}