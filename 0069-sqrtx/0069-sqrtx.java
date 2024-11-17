/**
Sunday, November 17, 2024 3:07:00 PM
T.C - O(n^2/n/logn/1√n) | S.C - O(n/1)
Verify it, Correct it. Explain it as well.
*/

class Solution {
    public int mySqrt(int x) {
        if(x<=0) return 0;
        if(x==1) return x;
        //return bruteForceApproach(x);
        return iterativeApproach(x);
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
    // You are not Handling Integer Overflow Properly root*root<=x
}