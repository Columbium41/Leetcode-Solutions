package medium;

// accepted: 100% time and 97.05% memory

public class q63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i > 0 && obstacleGrid[i - 1][j] == 1) {
                    dp[j] = 0;
                }
                if (j > 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}


