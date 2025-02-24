// Leetcode : 509
class Solution {
    public int fib(int n) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        //return recursiveSol(n);
        return dpHashMemo(n,memo);
    }

    public int dpHashMemo(int n,HashMap<Integer,Integer> memo){
        if(n==0) return 0;
        if(n==1) return 1;
        if(memo.containsKey(n)) return memo.get(n);
        int ways = dpHashMemo(n-1,memo) + dpHashMemo(n-2,memo);
        memo.put(n,ways);
        return ways;
    }


    public int recursiveSol(int n) {
        if(n==0){
            return 0;
        }
        return fibRecurr(n);        
    }
    public int fibRecurr(int n){
        if(n==0||n==1){
            return n;
        }
        return fibRecurr(n-1)+fibRecurr(n-2);
    }
}


    