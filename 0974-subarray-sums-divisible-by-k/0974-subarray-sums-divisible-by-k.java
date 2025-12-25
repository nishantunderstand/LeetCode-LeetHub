// LeetCode : 974
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> fMap = new HashMap<>();
        fMap.put(0,1);

        int cnt = 0;
        int csum = 0;

        for(int i=0;i<nums.length;i++){
            csum += nums[i];            
            int rem = csum%k;
            if(rem<0) rem+= k; // Normalize it                 
            cnt += fMap.getOrDefault(rem,0);                        
            fMap.put(rem,fMap.getOrDefault(rem,0)+1);
        }
        return cnt;
    }
}