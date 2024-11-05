package medium;

public class q3163 {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int cnt = 1;
        while(i < word.length()) {
            cnt = 1;
            while (i < word.length() - 1 && word.charAt(i) == word.charAt(i + 1) && cnt < 9) {
                cnt++;
                i++;
            }
            sb.append(cnt).append(word.charAt(i));
            i++;
        }

        return sb.toString();
    }
}
