// LeetCode : 90
// Saturday, November 7, 2026 11:56:23 AM    
// TC : O(n*2^n +nlogn) | SC : O(n*2^n) || // Auxiliary SC: O(n)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // For Removing Duplicate || You should sort it 
        // backtracking(nums, res, 0, new ArrayList<>());
        backtrackingFor(nums,res,0,new ArrayList<>());
        return res;
    }

    // Saturday, November 7, 2026 11:55:55 AM    
    // TC : O(n*2^n) | SC : O(n)
    private void backtrackingFor(int[] nums,List<List<Integer>> res, int idx, List<Integer> curr){
        res.add(new ArrayList<>(curr));

        for(int i=idx;i<nums.length;i++){ // Pick & Not-Pick
            if(i>idx && nums[i]==nums[i-1]) continue;

            curr.add(nums[i]); // DO 
            backtrackingFor(nums,res,i+1,curr); // Recurse
            curr.remove(curr.size()-1); // UNDO 
        }
    }

    private void backtracking(int[] nums, List<List<Integer>> res, int idx, List<Integer> curr) {
        // Base Case 
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]); // Do
        backtracking(nums, res, idx + 1, curr); // Recurse
        curr.remove(curr.size() - 1); // UnDo 
        // NotPick
        // Check For Duplicate || Here we are checking after that 
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        backtracking(nums, res, idx + 1, curr);
    }

}

