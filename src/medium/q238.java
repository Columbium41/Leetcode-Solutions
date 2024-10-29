package medium;

// follow-up: O(n) time and no division

public class q238 {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int totalProductNoZeros = 1;
        int[] output = new int[nums.length];
        int numZeros = 0;

        for (int num : nums) {
            if (num == 0) {
                numZeros++;
            } else {
                totalProductNoZeros *= num;
            }

            totalProduct *= num;
        }

        if (numZeros > 1)
            return output;

        for (int i = 0; i < nums.length; i++) {
            output[i] = nums[i] == 0 ? totalProductNoZeros : totalProduct / nums[i];
        }

        return output;
    }
}
