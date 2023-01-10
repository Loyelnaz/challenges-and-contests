package leetcode.challenge._2023.january;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Time complexity : O(N), where N is a number of nodes in the tree, since we visit each node exactly once
     * Space complexity : O(N), in the worst case of completely unbalanced tree, to keep a recursion stack
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if both the nodes are null, we can say they have reached a leaf node
        if (p == null && q == null) {
            return true;
        }

        // if either of them is null OR the values are not equal,
        // the tree is not identical
        if ((p == null || q == null) || p.val != q.val) {
            return false;
        }

        // if the above steps are satisfied, first we traverse
        // through the left child nodes, and then the right
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
