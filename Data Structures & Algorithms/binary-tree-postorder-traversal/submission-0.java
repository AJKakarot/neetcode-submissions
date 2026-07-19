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

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        postorder(root);

        return ans;
    }

    private void postorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // 1. Traverse Left
        postorder(root.left);

        // 2. Traverse Right
        postorder(root.right);

        // 3. Visit Current Node
        ans.add(root.val);
    }
}