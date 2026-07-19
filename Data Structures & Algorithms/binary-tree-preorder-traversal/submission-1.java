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

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return ans;
    }

    private void preorder(TreeNode root) {

        if (root == null) {
            return;
        }

        //  Visit Current Node
        ans.add(root.val);

        //  Traverse Left
        preorder(root.left);

        //  Traverse Right
        preorder(root.right);
    }
}