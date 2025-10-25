// LeetCode : 1748
class Solution {
    public int sumOfUnique(int[] nums) {        
        //return hashMapApproach(nums);
        //return singleHashSetApproach(nums);
        return twoHashSetApproach(nums);
    }
    // Sunday, October 26, 2025 1:17:21 AM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private int twoHashSetApproach(int[] nums){
        Set<Integer> unique = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();

        for(int num : nums){
            if(!unique.add(num)){
                duplicate.add(num);
            }
        }
        // Remove Duplicate
        unique.removeAll(duplicate);
        int csum=0;
        for(int num:unique){
            csum += num;
        }
        return csum;
    }


    // FAILED [1,1,1,1,1]
    private int singleHashSetApproach(int[] nums){
        Set<Integer> seen = new HashSet<>();
        int csum=0;
        for(int i=0;i<nums.length;i++){
            if(!seen.add(nums[i])){
                csum -= nums[i]; // AlreadySeen , Subtract From Sum
            }else{
                csum += nums[i]; // First Time Present
            }
        }
        return csum;
    }

    // Sunday, October 26, 2025 12:59:47 AM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private int hashMapApproach(int[] nums) {
        int n = nums.length;
        if(n==0){return 0;}
        if(n==1){return nums[0];}
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        int csum=0;
        for(int ikey : hm.keySet()){
            if(hm.get(ikey)==1){ // I want to compare Key should be 1
                //csum += hm.get(ikey); // No, You need to Add Key
                csum+=ikey;
            }
        }
        return csum;
    }
}