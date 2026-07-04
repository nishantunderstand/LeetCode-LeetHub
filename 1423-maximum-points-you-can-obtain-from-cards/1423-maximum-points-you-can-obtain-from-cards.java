// Leetcode : 1423
class Solution {
    public int maxScore(int[] cardPoints, int k) {        
        //return runningSumApproach(cardPoints,k);
        //return bruteForce(cardPoints,k);
        return slidingwindow(cardPoints,k);
    }
    // NeetCode Approach
    private int slidingwindow(int[] cardPoints, int k){
        int l = 0;
        int r = cardPoints.length-k;
        int total = 0;
        for(int i=r;i<cardPoints.length;i++){
            total += cardPoints[i];
        }
        int max = total;
        while(r<cardPoints.length){
            total += cardPoints[l] - cardPoints[r];
            max = Math.max(max,total);
            l++;
            r++;
        }
        return max;
    }

    // Saturday, July 4, 2026 10:01:46 AM
	// TC : O(2^n^2nlognk) | SC : O(1n2^nlogkh)
    private int bruteForce(int[] cardPoints, int k) {
        int leftSum = 0;
        for(int i=0;i<k;i++){
            leftSum += cardPoints[i];
        }
        
        int maxSum = leftSum;
        int rightSum = 0;

        for(int x=1;x<=k;x++){ //<--
            leftSum -= cardPoints[k-x]; // Remove 1 Number From Left
            rightSum += cardPoints[cardPoints.length-x]; // Add 1 Number From Right
            maxSum = Math.max(maxSum, leftSum+rightSum);
        }   
        return maxSum;
    }

    // Thursday, May 15, 2025 3:43:14 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private int runningSumApproach(int[] cardPoints, int k) {
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