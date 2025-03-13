// Leetcode : 779
class Solution {
    public int kthGrammar(int n, int k) {
        return findKthSymbolMIK(n,k);
    }
    public int findKthSymbolMIK(int n,int k){
        if(n==1) return 0; //<-- 

        int len = (int) Math.pow(2,n-1);
        int mid = len/2;

        if(k<=mid){ //<--
            return findKthSymbolMIK(n-1,k);
        }else{
            return 1-findKthSymbolMIK(n-1,k-mid); //<--
        }        
    }
}