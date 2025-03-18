class Solution {
    public List<String> generateParenthesis(int n) {
        return recursiveSol(n);
    }

    // Monday, November 18, 2024 7:02:48 PM
    // T.C - O(2^2n) | S.C - O(n)
    public List<String> recursiveSol(int n){
        List<String> res = new ArrayList<>();
        if(n<=0) return res;
        
        //recursiveHelper(res,"",0,0,n); //<--
        
        recursiveHelper2(res,"",n,n); //<--
        return res;
    }
    // Tuesday, November 19, 2024 11:34:32 AM
    // T.C - O(2^2n) | S.C - O(n)
    public void recursiveHelper2(List<String> res,String curr,int open,int close){
        if(open==0 && close==0){
            res.add(curr);
            return;
        }
        if(open>0){
            recursiveHelper2(res,curr+"(",open-1,close);
        }
        if(close>open){ //<--
            recursiveHelper2(res,curr+")",open,close-1);
        }
    }

    public void recursiveHelper(List<String> res,String curr,int open,int close,int n){
        // if(open>close) return; This Will LEAD TO WRONG RESULT.we mistakenly prune out valid recursive

        /** Base Case V1
        if(curr.length()==2*n){
            res.add(curr);
            return;
        }
        */

        if(open==n && close==n){
            res.add(curr);
            return;
        }
        
        if(open<n){ //<--
            recursiveHelper(res,curr+"(",open+1,close,n);
        }
        if(close<open){ //<--
            recursiveHelper(res,curr+")",open,close+1,n);
        }
    }
}