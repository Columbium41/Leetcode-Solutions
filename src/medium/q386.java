package medium;

import java.util.*;

public class q386 {
    public List<Integer> lexicalOrder(int n) {
        LinkedList<Integer> li = new LinkedList<>();
        int i = 1;

        while (li.size() < n) {
            li.add(i);

            if (i * 10 <= n)
                i *= 10;
            else {
                while (i == n || i % 10 == 9) {
                    i /= 10;
                }
                i++;
            }
        }

        return li;
    }

    public static void main(String[] args) {
        q386 instance = new q386();
        System.out.println(instance.lexicalOrder(13));
    }
}
