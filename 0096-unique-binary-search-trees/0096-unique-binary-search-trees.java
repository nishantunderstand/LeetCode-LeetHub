class Solution {
    public int numTrees(int n) {
        //return iterative(); //Pending
        //return recursive(); //Pending
        //return greedy(); //Pending
        //return backtracking(); //Pending
        //return dpTopDown(,dp); //Pending
        //return dpBottomUp(); //Pending
        //return dpSpace(); //Pending
        //return prefixApproach(); //Pending
        return catalanNumber(n); //Pending
    }

    // Thursday, February 6, 2025 1:23:48 PM
    // Time Complexity:O(n^2) | Space Complexity:O(n)
    public int catalanNumber(int n) {
        if(n==0||n==1) return 1; //<---
        int[] cat = new int[n+1];
        cat[0]=cat[1]=1; //<---
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                cat[i] = cat[i] + cat[j]*cat[i-j-1]; //<---
            }
        }
        return cat[n];
    }
}