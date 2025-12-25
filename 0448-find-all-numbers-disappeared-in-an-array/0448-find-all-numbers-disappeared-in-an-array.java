// LeetCode : 448
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {       
        return bruteForce(nums);
    }
    // Thursday, December 25, 2025 6:27:13 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private List<Integer> bruteForce(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        // Step 1: Store all present numbers
        for(int num : nums){            
            seen.add(num);            
        }
        // Step 2: Check which numbers from 1..n are missing
        for(int i=1;i<=nums.length;i++){
            if(!seen.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}