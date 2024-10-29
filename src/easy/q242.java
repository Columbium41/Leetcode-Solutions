package easy;

public class q242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] sChar = new int[26];
        int[] tChar = new int[26];

        for (char c : s.toCharArray()) {
            sChar[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tChar[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }

        return true;
    }
}
