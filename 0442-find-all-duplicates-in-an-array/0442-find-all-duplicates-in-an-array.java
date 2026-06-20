class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        if(nums==null) return res;   

        for(int i=0;i<nums.length;i++){
            if(seen.contains(nums[i])){
                res.add(nums[i]);
            }
            seen.add(nums[i]);
        }
        return res;
    }
}