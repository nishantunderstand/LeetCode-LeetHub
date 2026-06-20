class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Key : Sum , Value : Index 
        // As we need to search Sum
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int compliment = target-nums[i];
            if(hm.containsKey(compliment)){
                return new int[]{hm.get(compliment),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}