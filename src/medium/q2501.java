package medium;

// time: O(n)
// space: O(1)

public class q2501 {
    public int longestSquareStreak(int[] nums) {
        boolean[] b = new boolean[100001];

        for (int num : nums)
            b[num] = true;

        int longest = -1;

        for (int num : nums) {
            if (b[num]) {
                int len = 1;

                b[num] = false;
                double d_i = Math.sqrt(num);
                int i = (int)d_i;
                int j = num * num;

                while ((d_i - i == 0) && i >= 0 && b[i]) {
                    b[i] = false;
                    d_i = Math.sqrt(i);
                    i = (int)d_i;
                    len++;
                }
                while (j >= 0 && j < b.length && b[j]) {
                    b[j] = false;
                    j *= j;
                    len++;
                }

                if (len >= 2)
                    longest = Math.max(longest, len);
            }
        }

        return longest;
    }
}
