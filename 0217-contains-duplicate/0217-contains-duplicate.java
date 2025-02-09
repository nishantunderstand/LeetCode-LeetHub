class Solution {
    public boolean containsDuplicate(int[] nums) {
        //return bruteForceApproach(nums);        
        return sortingApproach(nums);
        //return hashSetApproach(nums);
        
    }

    // Sunday, February 9, 2025 2:01:58 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public boolean hashSetApproach(int[] nums) {
        HashSet<Integer> number = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (number.contains(nums[i])) {
                return true;
            }
            number.add(nums[i]);
        }
        return false;
    }

    public boolean sortingApproach(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // TLE
    public boolean bruteForceApproach(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

}