package medium;

public class q1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[Math.min(m, n) + 1];
        int[] lastRow = new int[Math.min(m, n) + 1];

        if (m > n) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[j] = 0;

                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[j] = 1 + lastRow[j - 1];
                    } else {
                        dp[j] = Math.max(dp[j - 1], lastRow[j]);
                    }
                }

                for (int k = 0; k < dp.length; k++) {
                    lastRow[k] = dp[k];
                }
            }
        } else {
            for (int j = 1; j <= n; j++) {
                for (int i = 1; i <= m; i++) {
                    dp[i] = 0;

                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i] = 1 + lastRow[i - 1];
                    } else {
                        dp[i] = Math.max(dp[i - 1], lastRow[i]);
                    }
                }

                for (int k = 0; k < dp.length; k++) {
                    lastRow[k] = dp[k];
                }
            }
        }

        // for (int i = 1; i <= m; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
        //             dp[i][j] = 1 + dp[i - 1][j - 1];
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //         }
        //     }
        // }

        return lastRow[Math.min(m, n)];
    }
}
