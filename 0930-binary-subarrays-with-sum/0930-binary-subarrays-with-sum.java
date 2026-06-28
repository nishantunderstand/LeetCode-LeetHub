// LeetCode : 930
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //return bruteForce(nums,goal);
        //return slidingwindow(nums,goal);
        return prefixSumSlidingWindow(nums,goal);        
    }

    private int prefixSumSlidingWindow(int[] nums, int goal) {
        // K : Sum , V : Index
        Map<Integer, Integer> pfSum = new HashMap<>();
        
        pfSum.put(0,1); //<--

        int left = 0;
        int windowSum = 0;
        int cnt = 0;
        
        for(int right=0;right<nums.length;right++){
            windowSum += nums[right];
            
            if(pfSum.containsKey(windowSum-goal)){
                cnt += pfSum.get(windowSum-goal);
            }

            pfSum.put(windowSum,pfSum.getOrDefault(windowSum,0)+1);            
        }
        return cnt;
    }



    // Sunday, June 28, 2026 1:50:27 PM
	// TC : O(2^n^2nlognk) | SC : O(1n2^nlogkh)
    // TODO
    private int slidingwindow(int[] nums, int goal) {
        int left = 0;
        int windowSum = 0;
        int cnt = 0 ;
        for(int right=0;right<nums.length;right++){
            windowSum += nums[right];

            while(windowSum>goal){
                windowSum -= nums[left];
                left++;
            }
            
        }
        return cnt;
    }



    // Sunday, June 28, 2026 1:48:28 PM
	// TC : O(n^2) | SC : O(1)
    private int bruteForce(int[] nums, int goal) {
        int cnt = 0;
        for(int start=0;start<nums.length;start++){
            int csum  = 0;
            for(int end=start;end<nums.length;end++){
                csum += nums[end];
                if(csum==goal) cnt++;
            }   
        }
        return cnt;
    }
}