class Solution {    
    public List<Integer> targetIndices(int[] nums, int target) {        
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        helper(nums,target,0, res);
        return res;        
    }
    private void helper(int[] nums, int data, int idx,List<Integer> res){
        if(idx==nums.length){
            return;
        }
        if(nums[idx]==data){            
            res.add(idx);            
        }
        helper(nums,data,idx+1,res);        
    }
}
// Saturday, May 30, 2026 7:45:04 PM
// TC : O(n) | SC : O(1)
// LeetCode : 2089