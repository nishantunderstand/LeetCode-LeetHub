// Leetcode : 322

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int result = dpMemo(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dpMemo(int[] coins, int amount, int[] dp) {
        if (amount < 0) return Integer.MAX_VALUE;
        if (amount == 0) return 0;
        if (dp[amount] != -1) return dp[amount];

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = dpMemo(coins, amount - coin, dp);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + res);
            }
        }

        dp[amount] = minCoins;
        return dp[amount];
    }
}
