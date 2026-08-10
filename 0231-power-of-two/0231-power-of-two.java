// LeetCode : 231
// Monday, August 10, 2026 10:21:27 PM
// TC : O(logn) | SC : O(1)
class Solution {
    public boolean isPowerOfTwo(int n) {
        //return bruteForce(n);
        //return bitsApproach(n); 
        //return direct(n);       
        return recursiveApproach(n);
    }
    // TC : O(logn) | SC : O(logn)
    private boolean recursiveApproach(int n){
        if(n<=0) return false;
        if(n==1) return true;
        if(n%2!=0) return false; //<--
        return recursiveApproach(n/2);
    }
    // TC : O(1) | SC : O(1)
    private boolean direct(int n){
        if(n<=0) return false;
        return Integer.bitCount(n)==1;
    }
    // TC : O(1) | SC : O(1)
    private boolean bitsApproach(int n){
        if(n<=0) return false;
        return (n & (n-1))==0;
    }

    // TC : O(logn) | SC : O(1)
    private boolean bruteForce(int n) {
        if(n<=0) return false;
        while(n>1){
            if(n%2!=0) return false;
            n = n/2;            
        }
        return true;
    }
}
