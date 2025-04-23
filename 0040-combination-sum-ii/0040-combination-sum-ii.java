// Leetcode : 40
class Solution {
    List<List<Integer>> result;
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {        
        this.result = new ArrayList<>();  //<--
        this.candidates = candidates;  //<--

        Arrays.sort(candidates);  
        
        /** 
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();                
        backtrackingFor(candidates,target,0,res,curr);
        return res;
        */

        backtrackingFor(target,0,new ArrayList<>());
        return result;
    }
    
    private void backtrackingFor(int target, int idx, List<Integer> curr){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;  //<--
            if(candidates[i]>target) break;  //<--

            curr.add(candidates[i]);
            backtrackingFor(target-candidates[i],i+1,curr);
            curr.remove(curr.size()-1);
        }
    }


    // Thursday, April 10, 2025 6:51:16 PM
    // Time Complexity:O(2^n*n) | Space Complexity:O(n)
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