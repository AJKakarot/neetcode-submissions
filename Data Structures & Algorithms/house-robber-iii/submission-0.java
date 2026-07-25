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

    public int rob(TreeNode root) {

        int[] options = dfs(root);

        return Math.max(options[0], options[1]);
    }

    private int[] dfs(TreeNode root) {

        // Base Case
        if (root == null) {
            return new int[]{0, 0};
        }

        // Get left subtree result
        int[] left = dfs(root.left);

        // Get right subtree result
        int[] right = dfs(root.right);

        // Option 1: Rob current node
        int rob = root.val + left[1] + right[1];

        // Option 2: Don't rob current node
        int notRob = Math.max(left[0], left[1])
                   + Math.max(right[0], right[1]);

        // Return both choices
        return new int[]{rob, notRob};
    }
}