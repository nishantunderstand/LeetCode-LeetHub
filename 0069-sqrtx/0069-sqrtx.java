class Solution {
    public int mySqrt(int x) {
        //return bruteForceApproach(x);
        //return iterativeApproach(x);
        return binarySearchApproach(x);
  
    }
    
    // T.C - O(1) | S.C - O(1)
    public int bruteForceApproach(int x){
        return (int) Math.sqrt(x);
    }

    // T.C - O(√n) | S.C - O(1)
    public int iterativeApproach(int x){
        int root = 1;
        int potRoot = 1;
        while(root<=x/root){ 
            potRoot = root;
            root++;
        }
        return potRoot;
    }

    // T.C - O(logn) | S.C - O(1)
    public int binarySearchApproach(int x){
        if(x<=0) return 0;
        if(x==1) return 1;
        int lo=1;
        int hi=x;
        int potAns=1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(mid<=x/mid){
                potAns=mid;
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return potAns;
    }
}