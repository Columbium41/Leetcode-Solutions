package hard;

// time: O(n)
// space: O(n)

public class q123 {
    /*
     * Idea 1: MLE
     * Let dp[i][j][k] = The max profit possible from days i to j (inclusively) with k + 1 transactions
     * Then max profit = dp[0][prices.length - 1][1]
     * Base case: dp[i][i][k] = 0
     * Recurrence Formula:
     * dp[i][j][0] = max(
                        dp[i][j - 1][0],
                        prices[j] - min(prices[i:j-1])
                     )
     * dp[i][j][1] = max(
                        dp[i][j][0],
                        max(dp[i][l][0] + dp[l + 1][j][0]) for i < l < j
                     )
     */

     /*
      * Idea 2
      * Let dp1[i] = max profit from day 0 to i (inclusive)
      * Let dp2[i] = max profit from day i to last day
      * Max profit = max(dp1[l] + dp2[l + 1]) for i < l < j
      * Base case: dp1[0] = 0, dp2[n - 1] = 0
      * Recurrence Formula:
      * dp1[i] = max(
                    dp[i - 1],
                    prices[i] - min(prices[:i-1])
                 )
      * dp2[i] = max(
                    dp[i + 1],
                    max(prices[i+1:]) - prices[i]
                 )
     */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        int currMin = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;

        int res = 0;
        for (int i = 1; i < n; i++) {
            currMin = Math.min(currMin, prices[i - 1]);
            dp1[i] = Math.max(dp1[i - 1], prices[i] - currMin);

            res = Math.max(res, dp1[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            currMax = Math.max(currMax, prices[i + 1]);
            dp2[i] = Math.max(dp2[i + 1], currMax - prices[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, dp1[i] + dp2[i + 1]);
        }

        return res;
    }
}
