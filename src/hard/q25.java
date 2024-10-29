package hard;

import java.util.*;
import leetcode.ListNode;

public class q25 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode globalHead = null;
        ListNode curr = head;
        ListNode localHead = head;
        ListNode next = head;
        ListNode prevTail = null;
        boolean firstIteration = true;

        int cnt = 0;
        while (curr != null) {
            // System.out.println("curr: " + curr.val);
            // if (cnt == 0) {
            //   System.out.println("new section");
            // }

            cnt++;

            if (cnt == k) {
                next = curr.next;
                curr.next = null;

                reverseLinkedList(localHead);
                localHead.next = next;

                if (firstIteration) {
                    globalHead = curr;
                    firstIteration = false;
                }

                if (prevTail != null) {
                    prevTail.next = curr;
                }

                cnt = 0;
                prevTail = localHead;
                curr = next;
                localHead = curr;
            } else {
                curr = curr.next;
            }
        }

        return globalHead;
    }

    // reverses a linked list and returns the new head of the list
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
