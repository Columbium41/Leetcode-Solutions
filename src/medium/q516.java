package medium;

public class q516 {
    /*
     * Let dp[i][j] = the length of the longest palindromic subsequence of s[i..j]

     * Base case:
     * dp[i][i] = 1 for 0 <= i < n
     * dp[j][i] = 0 for j > i
     * Recurrence:
     * dp[i][j] = 2 + dp[i + 1][j - 1] if s[i] == s[j]
     * dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]) if s[i] != s[j]
     */

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int[] last = new int[n];

        last[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[j] = 2 + last[j - 1];
                else
                    dp[j] = Math.max(last[j], dp[j - 1]);
            }

            for (int k = 0; k < n; k++) {
                last[k] = dp[k];
                dp[k] = 0;
            }
        }

        return last[n - 1];
    }
}
