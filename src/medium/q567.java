package medium;

import java.util.*;

public class q567 {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n)
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int bitmask = 0b100000000000000000000000000;
        int target = 0b111111111111111111111111111;

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            s2Count[s2.charAt(i) - 'a']++;
        }

        for (int i = 25; i >= 0; i--) {
            if (s1Count[i] == s2Count[i])
                bitmask ^= (int)(Math.pow(2, i));
        }
        if (bitmask == target)
            return true;

        for (int i = 1; i + m <= n; i++) {
            char prev = s2.charAt(i - 1);
            char next = s2.charAt(i + m - 1);

            if (prev == next)
                continue;

            s2Count[prev - 'a']--;
            s2Count[next - 'a']++;

            if (s2Count[prev - 'a'] + 1 == s1Count[prev - 'a'] || s2Count[prev - 'a'] == s1Count[prev - 'a'])
                bitmask ^= (int)(Math.pow(2, prev - 'a'));
            if (s2Count[next - 'a'] - 1 == s1Count[next - 'a'] || s2Count[next - 'a'] == s1Count[next - 'a'])
                bitmask ^= (int)(Math.pow(2, next - 'a'));

            if (bitmask == target)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        q567 instance = new q567();
        //System.out.println(instance.checkInclusion("ab", "eidbaooo"));
        System.out.println(instance.checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
    }
}
