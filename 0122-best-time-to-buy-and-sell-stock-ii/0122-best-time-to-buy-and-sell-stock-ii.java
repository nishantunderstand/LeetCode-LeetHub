class Solution {
    public int maxProfit(int[] prices) {
        //return backtrackingApproach(prices);
        return greedyApproach(prices);
    }

    // Left To Right
    public int backtrackingApproach(int[] prices) {
        return backtrackingHelper(prices,0);
    }
    
    public int backtrackingHelper(int[] prices,int idx) {
        if(idx>prices.length) return 0;        
        //int notpick = backtrackingApproach(prices,idx+1);        
        // Sell
        // Buy 
        // int pick = prices[idx] +backtrackingApproach(prices,idx+1); 
        // I need to add Difference, Not prices, This is a different Question
        return 0;
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