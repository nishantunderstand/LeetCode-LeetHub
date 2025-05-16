// Leetcode : 540
class Solution {
    public int singleNonDuplicate(int[] nums) {
        //return hashingApproach(nums);
        //return xorApproach(nums);
        return binarySearchByChatGPT(nums);
    }
    

    public int binarySearchByChatGPT(int[] nums) {       
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid = low + (high-low)/2; 
            if(mid%2==1) mid--; //<--
            if(nums[mid]==nums[mid+1]) low = mid+2;  //<--
            else{
                high = mid;  //<--
            }

        }
        return nums[low];  //<--
    }

    // Sunday, January 5, 2025 5:07:51 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int xorApproach(int[] nums){
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            ans=ans^nums[i];
        }
        return ans;
    }

    // Sunday, January 5, 2025 5:07:45 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int hashingApproach(int[] nums){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(Integer key : hm.keySet()){
            if(hm.get(key)==1){
                return key;
            }
        }
        return -1;
    }
}