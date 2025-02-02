class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        //backtracking(0,nums,res,curr);
        backtrackingForLoop(0,nums,res,curr);
        return res;
    }

    // Sunday, February 2, 2025 1:55:45 PM
    // Time Complexity:O(2^n) | Space Complexity:O(n)
    public void backtrackingForLoop(int idx,int[] nums,List<List<Integer>> res,List<Integer> curr){
        res.add(new ArrayList<>(curr));
        for(int i=idx;i<nums.length;i++){
            curr.add(nums[i]);
            backtrackingForLoop(i+1,nums,res,curr); //<-- i is Used
            curr.remove(curr.size()-1);
        }        
    }

    // Sunday, February 2, 2025 1:55:42 PM
    // Time Complexity:O(2^1) | Space Complexity:O(n)
    public void backtracking(int idx,int[] nums,List<List<Integer>> res,List<Integer> curr){
        if(idx==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        // Take
        curr.add(nums[idx]);
        backtracking(idx+1,nums,res,curr);
        curr.remove(curr.size()-1);

        // Don't Take
        backtracking(idx+1,nums,res,curr);
    }
}