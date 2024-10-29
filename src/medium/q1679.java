package medium;
import java.util.*;
public class q1679 {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = k - nums[i];

            int numFreq = map.getOrDefault(num, 0);
            int cFreq = map.getOrDefault(complement, 0);

            if (num == complement) {
                ans += numFreq / 2;
                map.put(num, numFreq - (numFreq / 2) * 2);
            } else {
                ans += Math.min(numFreq, cFreq);
                map.put(num, numFreq - Math.min(numFreq, cFreq));
                map.put(complement, cFreq - Math.min(numFreq, cFreq));
            }
        }

        return ans;
    }
}
