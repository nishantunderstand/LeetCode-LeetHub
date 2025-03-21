/**

1. Generate All pair , 2 Loops
2. Sort the Array , 2 Pointers   (TLE)
3. HashMap , Approach I don't Know
    nums[i]-k, nums[i]+k
    Do i need to use Math.abs ? No need.
4. Hashset , Not clear  , It will not store Duplicate , Not a Correct Approach

*/

// Leetcode : 2006
class Solution {
    public int countKDifference(int[] nums, int k) {
        //return bruteForce(nums,k);
        return hashMapApproach(nums,k);
        //return hashSetApproachDuplicateIssue(nums,k); // Will it handle Duplicates         
    }

    public int hashSetApproachDuplicateIssue(int[] nums, int k) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        return 0;
    }

    // Friday, March 21, 2025 8:38:39 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int hashMapApproach(int[] nums, int k) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        for(Integer num :nums){
            count +=hm.getOrDefault(num-k,0); //<-- Backward LookUp
            count +=hm.getOrDefault(num+k,0); //<-- Forward LookUp                    
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        return count;
    }


    /**
    1,2 is same as 2,1 
    Brute Force Approach
    */
    // Friday, March 21, 2025 8:38:17 PM
    // Time Complexity:O(n^2) | Space Complexity:O(1)
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