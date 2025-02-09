class Solution {
    public boolean containsDuplicate(int[] nums) {        
        return hashSetApproach(nums);
    }

    // Sunday, February 9, 2025 2:01:58 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public boolean hashSetApproach(int[] nums) {
        HashSet<Integer> number = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(number.contains(nums[i])){
                return true;
            }
            number.add(nums[i]);
        }
        return false;
    }
}