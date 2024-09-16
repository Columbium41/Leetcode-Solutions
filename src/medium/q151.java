package medium;

import java.util.*;

// accepted: 85.51% time and 43.34% memory

public class q151 {
    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < split.length / 2; i++) {
            String temp = split[i];
            split[i] =  split[split.length - i - 1];
            split[split.length - i - 1] = temp;
        }

        for (String str : split) {
            String trimmed = str.trim();
            if (!trimmed.isEmpty())
                sb.append(trimmed).append(" ");
        }

        sb.deleteCharAt(sb.toString().length() - 1);

        return sb.toString();
    }
}
