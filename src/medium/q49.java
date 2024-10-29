package medium;
import java.util.*;
public class q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[][] charCounts = new int[strs.length][26];

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (char c : str.toCharArray()) {
                charCounts[i][c - 'a']++;
            }
        }

        List<List<String>> anagrams = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = Arrays.toString(charCounts[i]);

            if (map.containsKey(key)) {
                anagrams.get(map.get(key)).add(strs[i]);
            } else {
                map.put(key, anagrams.size());
                LinkedList<String> newList = new LinkedList<>();
                newList.addLast(strs[i]);
                anagrams.add(newList);
            }
        }

        return anagrams;
    }
}
