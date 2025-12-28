class Solution {
    public int maxProfit(int[] prices) {
        return bruetForce(prices);
    }
    // Sunday, January 26, 2025 1:57:19 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int bruetForce(int[] prices) {
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxPro = Math.max(maxPro, prices[i] - minPrice);
        }
        return maxPro;
    }
}