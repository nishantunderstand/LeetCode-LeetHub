class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int target = len/2;   
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(entry.getValue()>target){ //<--
                return entry.getKey();
            }
        }
        return -1;
    }
}