package hard;

public class q10 {
    /*
     */
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // base case:
        dp[n][m] = true;
        // s is empty and p is not empty
        for (int i = m - 1; i >= 0; i--) {
            if (p.charAt(i) == '*')
                continue;

            if (i + 1 < m && p.charAt(i + 1) == '*')
                dp[n][i] = true;
            else
                break;
        }

        // recurrence
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                char sc = s.charAt(i);
                char pc = p.charAt(j);
                char npc = (j + 1 < m) ? p.charAt(j + 1) : '-';

                // 0 or more of pc
                if (npc == '*') {
                    dp[i][j] = dp[i][j] || dp[i][j + 2];

                    if (sc == pc || pc == '.') {
                        dp[i][j] = dp[i][j] || dp[i + 1][j];
                    }
                } else if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
