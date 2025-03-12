// Leetcode : 122
// Leetcode : 121 How Different From it ?
class Solution {
    public int maxProfit(int[] prices) {        
        return greedyApproach(prices);
    }


    // Multiple Buy and Sell Possible
    // Sunday, January 26, 2025 9:44:24 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int greedyApproach(int[] prices) {
        int n = prices.length;
        if(prices==null || n<2) return 0;
        int profit = 0;
        for(int i=1;i<n;i++){
            if(prices[i-1]<prices[i]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}