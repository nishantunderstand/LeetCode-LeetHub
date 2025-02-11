// LeetCode 39
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        //backtrackingApproach(candidates,target,0,res,curr);
        backtrackingApproachFor(candidates,target,0,res,curr);
        return res;
    }

    // Tuesday, February 11, 2025 9:46:24 PM
    // Time Complexity:O(2^n) | Space Complexity:O(n)    
    public void backtrackingApproach(int[] candidates,int target,int index, List<List<Integer>> res, List<Integer> curr){
        if(target==0){
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        if(target<0 || index==candidates.length) return; //<--
        
        curr.add(candidates[index]);
        backtrackingApproach(candidates,target-candidates[index],index,res,curr);
        curr.remove(curr.size()-1);
        
        backtrackingApproach(candidates,target,index+1,res,curr);        
    }  


    public void backtrackingApproachFor(int[] candidates,int target,int index, List<List<Integer>> res, List<Integer> curr){
        if(target==0){
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        if(target<0) return;
        
        for(int i=index;i<candidates.length;i++){
            curr.add(candidates[i]);
            backtrackingApproachFor(candidates,target-candidates[i],i,res,curr); //<--
            curr.remove(curr.size()-1);
        }        
    }  
}