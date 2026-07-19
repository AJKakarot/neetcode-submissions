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
import java.util.*;

class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {

        // Base Case
        if (root == null) {
            return;
        }

        // Traverse Left Subtree
        inorder(root.left);

        // Visit Current Node
        ans.add(root.val);

        // Traverse Right Subtree
        inorder(root.right);
    }
}