package medium;

import java.util.*;

// time: O(n)
// space: O(n) (can maybe improve)

public class q167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        LinkedList<Integer> al = new LinkedList<>();

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                al.addLast(l + 1);
                al.addLast(r + 1);
                l++;
                r--;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        int[] arr = new int[al.size()];
        int i = 0;

        for (int num : al) {
            arr[i++] = num;
        }

        return arr;
    }
}
