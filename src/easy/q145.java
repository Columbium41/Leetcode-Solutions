package easy;

import leetcode.TreeNode;

import java.util.*;

public class q145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> nodes = new LinkedList<>();

        if (root == null)
            return nodes;

        postorderTraversalHelper(root, nodes);

        return nodes;
    }

    public void postorderTraversalHelper(TreeNode node, LinkedList<Integer> li) {
        if (node.left != null)
            postorderTraversalHelper(node.left, li);
        if (node.right != null)
            postorderTraversalHelper(node.right, li);

        li.add(node.val);
    }
}
