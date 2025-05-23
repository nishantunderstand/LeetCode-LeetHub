// Leetcode : 1423
class Solution {
    public int maxScore(int[] cardPoints, int k) {        
        return runningSumApproach(cardPoints,k);
    }

    // Thursday, May 15, 2025 3:43:14 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int runningSumApproach(int[] cardPoints, int k) {
        if(cardPoints==null || cardPoints.length==0 || k>cardPoints.length ||k<0) return 0;
        int n = cardPoints.length;
        int cSum = 0;
        for(int i=0;i<k;i++){
            cSum += cardPoints[i];
        }
        int maxSum = cSum; //<--

        // Running Sum Approach
        for(int i=1;i<=k;i++){
            cSum = cSum + cardPoints[n-i] - cardPoints[k-i];  //<--
            maxSum = Math.max(cSum,maxSum);
        }
        return maxSum;
    }
}