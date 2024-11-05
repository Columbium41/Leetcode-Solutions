package medium;

public class q3 {
    /*
     * abcabcbb
     * [a]bcabcbb ==> 1
     * [ab]cabcbb ==> 2
     * [abc]abcbb ==> 3
     * [abca]bcbb ==> repeating, move sliding window to the right until no repeating chars
     * a[bca]bcbb ==> 3
     * a[bcab]cbb ==> repeating
     * ab[cab]cbb ==> 3
     * ...
     * O(n) time and O(1) space
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        int longest = 0;
        int nUnique = 0;
        int[] ascii = new int[128];

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            // add character to longest substring
            if (ascii[c] == 0) {
                ascii[c]++;
                nUnique++;
                longest++;
            }

            // move sliding window one to the right until there are no repeating characters
            else {
                while (i < s.length()) {
                    char prev = s.charAt(i - longest);
                    char next = s.charAt(i);

                    if (prev != next && ascii[next] == 0)
                        nUnique++;
                    if (prev != next && ascii[prev] == 1)
                        nUnique--;

                    ascii[prev]--;
                    ascii[next]++;

                    if (nUnique == longest) {
                        break;
                    }
                    i++;
                }
            }

            i++;
        }

        return longest;
    }
}
