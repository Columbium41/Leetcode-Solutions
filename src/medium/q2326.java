package medium;

import java.util.*;
import leetcode.ListNode;

// accepted: 87.82% time and 24.71% memory

public class q2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        ListNode current = head;
        int left = 0;
        int right = 0;
        int top = 0;
        int bot = 0;
        /*
         * 0 - right
         * 1 - down
         * 2 - left
         * 3 - up
         * */
        int dir = 0;

        int row = 0;
        int col = 0;
        int idx = 0;

        while (idx < m * n) {
            //System.out.println("OUTER: (" + row + "," + col + ")");
            switch(dir) {
                case 0:
                    while (col < n - right) {
                        if (current == null) {
                            mat[row][col++] = -1;
                        } else {
                            mat[row][col++] = current.val;
                            current = current.next;
                        }
                        //System.out.println("(" + row + "," + (col - 1) + ") - " + mat[row][col - 1]);

                        idx++;
                    }
                    col--;
                    row++;
                    top++;
                    dir = 1;
                    break;
                case 1:
                    while (row < m - bot) {
                        if (current == null) {
                            mat[row++][col] = -1;
                        } else {
                            mat[row++][col] = current.val;
                            current = current.next;
                        }

                        //System.out.println("(" + (row - 1) + "," + col + ") - " + mat[row - 1][col]);

                        idx++;
                    }
                    row--;
                    col--;
                    right++;
                    dir = 2;
                    break;
                case 2:
                    while (col >= left) {
                        if (current == null) {
                            mat[row][col--] = -1;
                        } else {
                            mat[row][col--] = current.val;
                            current = current.next;
                        }

                        //System.out.println("(" + row + "," + (col + 1) + ") - " + mat[row][col + 1]);

                        idx++;
                    }
                    col++;
                    row--;
                    bot++;
                    dir = 3;

                    break;
                case 3:
                    while (row >= top) {
                        if (current == null) {
                            mat[row--][col] = -1;
                        } else {
                            mat[row--][col] = current.val;
                            current = current.next;
                        }

                        //System.out.println("(" + (row + 1) + "," + col + ") - " + mat[row + 1][col]);

                        idx++;
                    }
                    row++;
                    col++;
                    left++;
                    dir = 0;

                    break;
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        q2326 instance = new q2326();
    }
}
