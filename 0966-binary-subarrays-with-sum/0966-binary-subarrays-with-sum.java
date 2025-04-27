// Leetcode : 930
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // return slidingWindow(nums,goal) - slidingWindow(nums,goal-1);
        return prefixHashMapApprpach(nums,goal);
    }

    private int prefixHashMapApprpach(int[] nums,int goal){
        // Sum-Integer
        HashMap<Integer,Integer> hm = new HashMap<>();
        int windowSum=0,cnt=0;
        hm.put(0,1);  //<--
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum +=nums[windowEnd];   
            int compliment = windowSum -goal;       
            if(hm.containsKey(compliment)){
                cnt +=  hm.get(compliment);
            }
            hm.put(windowSum,hm.getOrDefault(windowSum,0)+1);
        }
        return cnt;
    }

    public int slidingWindow(int[] nums, int goal) {
        if(goal<0) return 0;

        int windowSum = 0,windowStart = 0, cnt=0;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum += nums[windowEnd];
            
            while(windowSum>goal){
                windowSum -= nums[windowStart];
                windowStart++;
            }
            cnt += (windowEnd-windowStart+1);
        }
        return cnt;
    }
}