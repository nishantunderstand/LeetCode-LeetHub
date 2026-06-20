class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,n,"",0,0);
        return res;
    }

    private void helper(List<String> ans, int n,String curr,int open , int close){
        // Base Case
        if(open==n && close ==n){
            ans.add(curr);
            return;
        }
        // Recursive Function, Pick (, )        
        if(open<n){
            helper(ans,n,curr+"(",open+1,close);
        }
        
        if(close<open){ //<--
            helper(ans,n,curr+")",open,close+1);
        }
        
    }
}
// Sunday, June 7, 2026 2:54:08 PM
// TC : O(2^n) | SC : O(n)
// LeetCode : 22