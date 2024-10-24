/**
Thursday, October 24, 2024 10:22:12 PM
Finding TimeComplexity Formula : No of Function Call * TC per Call

Verify it, Correct it. Explain it as well.
BRUTEFORCEAPPROACH | OPTIMALAPPROACH | SPACEOPTIMIZIEDAPPROACH

Thinking of HashSet NO 
Think of HashMap - We need to return the Frequency of Occurence.

[-1,-1,1]  , K=0 

n<=0 || k<=0 return 0; // This is WRONG, Applying Constraint on k is WRONG

T.C - O(n)
S.C - O(n)
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n<=0) return 0; 
              
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1); 
        int csum = 0;
        int cnt = 0;
        for(int i=0;i<n;i++){
            csum +=nums[i];
            if(hm.containsKey(csum-k)){
                cnt+=hm.get(csum-k);
            }
            hm.put(csum,hm.getOrDefault(csum,0)+1);
        }
        return cnt;
    }
}