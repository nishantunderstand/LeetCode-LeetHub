class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return backtrackingApproach(nums);
    }

    // Wednesday, January 29, 2025 6:41:02 PM
    // Time Complexity:O(n!) | Space Complexity:O(n!)
    public List<List<Integer>> backtrackingApproach(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        helper(res, inner, nums, vis);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> inner, int[] nums, boolean[] vis) {
        if (inner.size() == nums.length) {
            res.add(new ArrayList<>(inner));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(vis[i]) continue;
            
            inner.add(nums[i]);
            vis[i] = true;
            helper(res, inner, nums, vis);
            inner.remove(inner.size() - 1);
            vis[i] = false;
        }
    }
}