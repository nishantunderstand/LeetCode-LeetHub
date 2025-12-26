// Leetcode : 287
class Solution {
    public int findDuplicate(int[] nums) {        
        //return hashMapApproach(nums);
        return hashsetApproach(nums);
    }

    private int hashsetApproach(int[] nums){
        Set<Integer> seen = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(seen.contains(nums[i])){
                return nums[i];
            }
            seen.add(nums[i]);
        }
        return -1;
    }

    // Wednesday, May 14, 2025 9:15:41 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int hashMapApproach(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer num : nums) {
            if (hm.containsKey(num)) {
                return num;
            }
            hm.put(num, 1); // Why are we not checking getOrDefault ?
            // Using getOrDefault(num, 0) > 0 would also work, but it's unnecessary in this context, since the map is only storing presence.
        }
        return -1;
    }

}