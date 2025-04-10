// Leetcode : 216
// No Duplicate
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrackingFor(res,curr,1,n,k);
        return res;
    }

    private void backtrackingFor(List<List<Integer>> res,List<Integer> curr,int idx,int target,int len){
        // Base Case
        if(curr.size()==len && target==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        // Guard Case
        if(curr.size()>len || target<0) return;

        // 1to9 
        for(int i=idx;i<=9;i++){ //<--
            curr.add(i);
            backtrackingFor(res,curr,i+1,target-i,len); //<--
            curr.remove(curr.size()-1);
        }
    }
}