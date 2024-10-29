package medium;

import java.util.*;

// time: O(n)
// space: O(1)
public class q128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        int longest = 1;

        for (int num : nums)
            set.add(num);

        for (int num : nums) {
            if (set.contains(num)) {
                int len = 1;

                set.remove(num);

                int i = num + 1;
                int j = num - 1;
                while (set.contains(i)) {
                    set.remove(i);
                    len++;
                    i++;
                }
                while (set.contains(j)) {
                    set.remove(j);
                    len++;
                    j--;
                }

                longest = Math.max(longest, len);
            }
        }

        return longest;
    }
}
