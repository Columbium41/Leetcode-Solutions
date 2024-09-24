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
        int maxCoins = Integer.MIN_VALUE;
        int[][] memo = new int[n][n];  // max coins you can get from [i..j] in nums

        return recurse(nums, 0, n - 1, memo);
    }

    public int recurse(int[] nums, int l, int r, int[][] memo) {
        // System.out.println("l: " + l + ", r: " + r);
        int n = nums.length;
        int maxScore = Integer.MIN_VALUE;

        // base case
        if (l > r)
            return 0;

        if (memo[l][r] != 0)
            return memo[l][r];

        // nums[i] is the last balloon to be popped in nums[l..r]
        for (int i = l; i <= r; i++) {
            int popped = nums[i];
            if (l > 0)
                popped *= nums[l - 1];
            if (r < n - 1)
                popped *= nums[r + 1];

            maxScore = Math.max(maxScore,
                    recurse(nums, l, i - 1, memo) +
                            popped +
                            recurse(nums, i + 1, r, memo)
            );
        }

        memo[l][r] = maxScore;
        return maxScore;
    }
}
