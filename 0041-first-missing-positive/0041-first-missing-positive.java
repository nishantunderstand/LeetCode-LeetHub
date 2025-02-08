class Solution {
    public int firstMissingPositive(int[] nums) {
        return hashSetApproach(nums);
    }
    // Saturday, February 8, 2025 2:58:44 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int hashSetApproach(int[] nums) {
        int len = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        // Adding All the Element to HashSet
        for(int i=0;i<len;i++){
            hs.add(nums[i]);
        }
        // Checking for Missing Positive, Count From 1 to n+1
        for(int i=1;i<=len+1;i++){ //<--
            if(!hs.contains(i)) return i;
        }
        return -1;
    }

}