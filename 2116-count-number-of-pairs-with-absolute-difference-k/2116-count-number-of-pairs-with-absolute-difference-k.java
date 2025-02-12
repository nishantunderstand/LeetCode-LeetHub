/**

1. Generate All pair , 2 Loops
2. Sort the Array , 2 Pointers   (TLE)
3. HashMap , Approach I don't Know
    nums[i]-k, nums[i]+k
    Do i need to use Math.abs ? No need.
4. Hashset , Not clear  , It will not store Duplicate , Not a Correct Approach
*/

class Solution {
    public int countKDifference(int[] nums, int k) {
        //return bruteForce(nums,k);
        return hashMapApproach(nums,k);
        //return hashSetApproach(nums,k);    
        

    }

    public int hashSetApproach(int[] nums, int k) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++){
           
        }
        return 0;
    }

    public int hashMapApproach(int[] nums, int k) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        for(Integer num :nums){
            count +=hm.getOrDefault(num-k,0);
            count +=hm.getOrDefault(num+k,0);                       
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        return count;
    }


/**
1,2 is same as 2,1 
Brute Force Approach
*/
    public int bruteForce(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        if(n==0) {return 0;}
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(Math.abs(nums[i]-nums[j])==k){
                    count++;
                }
            }
        }
        return count;
    }
}