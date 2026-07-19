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

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Case 1
        if (p == null && q == null) {
            return true;
        }

        // Case 2
        if (p == null || q == null) {
            return false;
        }

        // Case 3
        if (p.val != q.val) {
            return false;
        }

        // Compare Left and Right
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}