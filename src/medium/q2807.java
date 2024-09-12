package medium;

import leetcode.ListNode;
import java.util.*;

// accepted: 100% time and 21.62% memory
public class q2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;

        while (current.next != null) {
            // System.out.println("GCD(" + current.val + "," + current.next.val + "): " + GCD(current.val, current.next.val));
            ListNode gcd = new ListNode(GCD(current.val, current.next.val), current.next);
            current.next = gcd;
            current = gcd.next;
        }

        return head;
    }

    public int GCD(int a, int b) {
        if (a < b)
            return GCD(b, a);

        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
