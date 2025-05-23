// Leetcode : 518

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return countWays(coins, 0, amount, dp);
    }

    private int countWays(int[] coins, int index, int amount, int[][] dp) {
        if (amount == 0) return 1;
        if (index == coins.length) return 0;

        if (dp[index][amount] != -1) return dp[index][amount];

        int ways = 0;
        // Option 1: Include coin[index] if it's ≤ amount
        if (coins[index] <= amount)
            ways += countWays(coins, index, amount - coins[index], dp);

        // Option 2: Skip coin[index]
        ways += countWays(coins, index + 1, amount, dp);

        return dp[index][amount] = ways;
    }
}
