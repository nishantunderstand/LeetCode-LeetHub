// LeetCode : 1248
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {                
        //return bruteForce(nums,k);
        //return slidingWinodwAtMost(nums,k) - slidingWinodwAtMost(nums,k-1); 
        return prefixHashMap(nums,k);
    }

    private int prefixHashMap(int[] nums, int k){
        // K - Last Odd Postion , V - Index
        Map<Integer,Integer> pfSum = new HashMap<>();
        pfSum.put(0,1); // WHY ???

        int cnt = 0;        
        int sum = 0;

        for(int right=0;right<nums.length;right++){            
            sum += (nums[right]%2);  // ???
            if(pfSum.containsKey(sum-k)){
                cnt += pfSum.get(sum-k);
            }
            pfSum.put(sum,pfSum.getOrDefault(sum,0)+1); //??
            
        }
        return cnt;
    }

    // Postive Array
    private int slidingWinodwAtMost(int[] nums, int k){
        int left = 0;
        int oddCnt = 0;
        int cnt = 0;

        int len = nums.length;
        
        for(int right=0;right<len;right++){
            if(nums[right]%2==1) oddCnt++;

            while(oddCnt>k){
                if(nums[left]%2==1){
                    oddCnt--;
                }

                left++;
            }
            cnt += (right-left+1);
        }
        return cnt;
    }

    // Sunday, June 28, 2026 6:49:57 PM
	// TC : O(n^2) | SC : O(1)
    private int bruteForce(int[] nums, int k) {        
        int cnt = 0;
        int len = nums.length;
        for(int start=0;start<len;start++){
            int oddCnt = 0;
            for(int end=start;end<len;end++){ //<--
                if(nums[end]%2==1) oddCnt++;
                if(oddCnt==k) cnt++;
            }
        }
        return cnt;
    }
}