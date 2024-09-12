package medium;

import java.util.*;

// accepted: 100% time and 96.14% memory
// O(n^2) time and O(n) memory

public class q62 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
