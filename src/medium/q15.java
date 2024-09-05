package medium;

import utils.Pair;

import java.util.*;

// accepted: 46.71% time and 6.58% memory

public class q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // System.out.println("[" + i + "," + j + "," + k + "] = " + sum);
                if (sum == 0) {
                    ans.add(new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[k])));

                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (j < k && nums[k] == nums[k - 1])
                        k--;

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        q15 instance = new q15();
        // [-4, -1, -1, 0, 1, 2]
        System.out.println(instance.threeSum(new int[] {-1,0,1,2,-1,-4}));
    }
}
