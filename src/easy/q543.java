package easy;

import java.util.*;
import leetcode.TreeNode;

public class q543 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    public int dfs(TreeNode node)
    {
        if (node == null)
            return 0;

        int l = 0;
        int r = 0;

        if (node.left != null) {
            l = 1 + dfs(node.left);
        }
        if (node.right != null) {
            r = 1 + dfs(node.right);
        }

        maxDiameter = Math.max(maxDiameter, l + r);

        return Math.max(l, r);
    }
}
