package medium;

import java.util.*;

// time: O(n^2)
// memory: O(1)

public class q1371 {
    public int findTheLongestSubstring(String s) {
        int longest = 0;

        // a, e, i, o, u
        int vowelCounts = 0B11111;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'a':
                    vowelCounts = vowelCounts ^ 0B10000;
                    break;
                case 'e':
                    vowelCounts = vowelCounts ^ 0B01000;
                    break;
                case 'i':
                    vowelCounts = vowelCounts ^ 0B00100;
                    break;
                case 'o':
                    vowelCounts = vowelCounts ^ 0B00010;
                    break;
                case 'u':
                    vowelCounts = vowelCounts ^ 0B00001;
                    break;
                default:
                    break;
            }
        }


        // start at index 0
        for (int i = 0; i < s.length(); i++) {
            int currentVowels = vowelCounts;

            if (currentVowels == 31 && (s.length() - i) > longest) {
                longest = s.length() - i;
            }

            // j is the index of the character to be removed
            for (int j = s.length() - 1; j > i; j--) {
                if (longest >= (j - i))
                    break;

                switch (s.charAt(j)) {
                    case 'a':
                        currentVowels = currentVowels ^ 0B10000;
                        break;
                    case 'e':
                        currentVowels = currentVowels ^ 0B01000;
                        break;
                    case 'i':
                        currentVowels = currentVowels ^ 0B00100;
                        break;
                    case 'o':
                        currentVowels = currentVowels ^ 0B00010;
                        break;
                    case 'u':
                        currentVowels = currentVowels ^ 0B00001;
                        break;
                    default:
                        break;
                }

                if (currentVowels == 31 && (j - i) > longest) {
                    longest = j - i;
                }
            }

            switch (s.charAt(i)) {
                case 'a':
                    vowelCounts = vowelCounts ^ 0B10000;
                    break;
                case 'e':
                    vowelCounts = vowelCounts ^ 0B01000;
                    break;
                case 'i':
                    vowelCounts = vowelCounts ^ 0B00100;
                    break;
                case 'o':
                    vowelCounts = vowelCounts ^ 0B00010;
                    break;
                case 'u':
                    vowelCounts = vowelCounts ^ 0B00001;
                    break;
                default:
                    break;
            }
        }

        return longest;
    }
}
