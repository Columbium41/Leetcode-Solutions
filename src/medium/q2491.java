package medium;

import java.util.*;
import java.io.*;

public class q2491 {
    public long dividePlayers(int[] skill) {
        int[] freqCounter = new int[1001];
        long sum = 0l;
        long chemistry = 0;

        for (int s : skill) {
            freqCounter[s]++;
            sum += s;
        }

        long avg = sum / (skill.length / 2);

        for (int i = 1; i < freqCounter.length; i++) {
            int complement = (int)(avg) - i;

            if (complement < 1 || complement >= freqCounter.length)
                continue;

            int freq = freqCounter[i];
            int freqComplement = freqCounter[complement];

            if (freq != freqComplement)
                return -1;

            long toAdd = (long)(freq) * (long)(i) * (long)(complement);
            if (i == complement)
                toAdd /= 2;

            chemistry += toAdd;
            if (freq != 0) {
                freqCounter[i] = 0;
                freqCounter[complement] = 0;
            }
        }

        return chemistry;
    }
}
