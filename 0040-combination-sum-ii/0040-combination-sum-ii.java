// Leetcode : 40
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackingFor(candidates,target,0,res,curr);
        return res;
    }
    
    // Thursday, April 10, 2025 6:51:16 PM
    // Time Complexity:O(V+En^2^nm*nlognHeightOfTree1Width) | Space Complexity:O(1V+Em*nHeightOfTreeWidth)
    private void backtrackingFor(int[] candidates,int target,int idx,List<List<Integer>> res, List<Integer> curr){
        // Base Case
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;            
        }

        for(int i=idx;i<candidates.length;i++){            
            if(i>idx && candidates[i]==candidates[i-1]) continue; // Handling Duplicates
            
            if(candidates[i]>target) break; // Prune
            
            curr.add(candidates[i]);
            backtrackingFor(candidates,target-candidates[i],i+1,res,curr);
            curr.remove(curr.size()-1);
        }
    }
}