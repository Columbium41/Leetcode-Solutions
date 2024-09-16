package medium;

import java.util.*;

// accepted: 48.18% time and 33.84% memory
// time: O(nlogn)
// memory: O(n)

public class q539 {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];

        int idx = 0;
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            times[idx++] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }

        Arrays.sort(times);

        int min = 24 * 60 - (times[times.length - 1] - times[0]);

        for (int i = 1; i < times.length; i++) {
            min = Math.min(min, times[i] - times[i - 1]);

            if (min == 0)
                break;
        }

        return min;
    }

    public static void main(String[] args) {
        q539 instance = new q539();
        System.out.println(instance.findMinDifference(Arrays.asList(new String[] {"00:00","23:59","00:00"})));
    }
}
