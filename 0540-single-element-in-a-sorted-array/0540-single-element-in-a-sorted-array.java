class Solution {
    public int singleNonDuplicate(int[] nums) {
        return hashingApproach(nums);
        //return xorApproach(nums);
    }

    public int xorApproach(int[] nums){
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            ans=ans^nums[i];
        }
        return ans;
    }

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