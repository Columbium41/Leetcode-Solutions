package hard;

import java.util.*;

// time: O(n^3)
// space: O(n^2)

/*
* Explanation: recurse(nums, l, r, memo) ==> returns the max coins you can get from nums[l:r]
* Answer = recurse(nums, 0, nums.length - 1, memo)
* for the recurse algorithm:
* loop from [l..r] with index i:
* pick nums[i] to be the LAST balloon to be popped in the range [l..r]
* the amount of coins you get from popping nums[i] is (nums[i] * nums[l - 1] * nums[r + 1])
* sum the amount you get from popping nums[i] with the two subtrees:
    * recurse(nums, l, i - 1, memo)
    * recurse(nums, i + 1, r, memo)
* memoize the solution afterwards
* */

public class q312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++)
            dp[i][i] = arr[i - 1] * arr[i] * arr[i + 1];

        for (int i = n; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], arr[i - 1] * arr[k] * arr[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }

        return dp[1][n];
    }
}
