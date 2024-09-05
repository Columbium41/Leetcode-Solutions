package medium;

import java.util.*;

// accepted: 72.36% time and 61.80% memory
public class q2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int currentSum = 0;

        for (int roll : rolls)
            currentSum += roll;

        double minMean = (double)(currentSum + n) / (double)(n + m);
        double maxMean = (double)(currentSum + n * 6) / (double)(n + m);

        if (mean > maxMean || mean < minMean)
            return new int[] {};

        int remainingNeeded = (mean * (n + m)) - currentSum;
        int[] remaining = new int[n];
        Arrays.fill(remaining, remainingNeeded / n);
        remainingNeeded -= remaining[0] * n;

        for (int i = 0; i < remaining.length && remainingNeeded > 0; i++) {
            if (remaining[i] == 6)
                continue;
            remaining[i]++;
            remainingNeeded--;
        }

        return remaining;
    }
}
