// Leetcode : 442
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Hashing Approach
        return hashingApproach(nums);
    }


    public List<Integer> hashingApproach(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // Key-Element | Value - Frequency
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            if(entry.getValue()==2){
                res.add(entry.getKey());
            }
        }
        return res;
    }
}