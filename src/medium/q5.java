package medium;

public class q5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int longest = 1;
        int longestIdx = 0;

        for (int i = 0; i < n; i++) {
            // odd length
            int l = i - 1;
            int r = i + 1;
            int local = 1;

            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    local += 2;
                    l--;
                    r++;
                } else {
                    break;
                }
            }

            if (local > longest) {
                longest = local;
                longestIdx = i;
            }

            // even length
            local = 0;
            l = i;
            r = i + 1;

            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    local += 2;
                    l--;
                    r++;
                } else {
                    break;
                }
            }

            if (local > longest) {
                longest = local;
                longestIdx = i;
            }
        }

        int half = longest / 2;
        if (longest % 2 == 1)
            return s.substring(longestIdx - half, longestIdx + half + 1);

        return s.substring(longestIdx - half + 1, longestIdx + half + 1);
    }
}
