// Leetcode : 90
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums); //<--
        int len = nums.length;
        backtracking(0,nums,res,curr);
        return res;
    }
    
    // Saturday, February 15, 2025 9:52:34 PM
    // Time Complexity:O(2^n) | Space Complexity:O(n)
    public void backtracking(int idx,int[] nums,List<List<Integer>> res,List<Integer> curr){
        res.add(new ArrayList<>(curr));    
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue; //<--

            curr.add(nums[i]);            
            backtracking(i+1,nums,res,curr);
            curr.remove(curr.size()-1);
        }
    }
}


    