package medium;

import java.util.*;

public class q347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashSet<Integer>[] counts = new HashSet[nums.length + 1];
        int[] freq = new int[20001];
        int[] ans = new int[k];

        for (int i = 0; i < counts.length; i++) {
            counts[i] = new HashSet<>();
        }

        for (int num : nums) {
            if (freq[num + 10000]++ > 0) {
                counts[freq[num + 10000] - 1].remove(num);
            }
            counts[freq[num + 10000]].add(num);
        }

        int j = 0;
        for (int i = nums.length; i > 0 && j < k; i--) {
            HashSet<Integer> set = counts[i];

            for (int num : set) {
                ans[j++] = num;

                if (j == k) {
                    break;
                }
            }
        }

        return ans;
    }
}
