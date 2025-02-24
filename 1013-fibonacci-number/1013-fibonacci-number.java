class Solution {
    public int fib(int n) {
        return recursiveSol(n);
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


    