class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtracking(0,nums,res,curr);
        return res;
    }
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