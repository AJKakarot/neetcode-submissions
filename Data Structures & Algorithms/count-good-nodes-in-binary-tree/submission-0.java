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
public:
    int dfs(TreeNode* root, int maxSoFar) {
        if (root == nullptr)
            return 0;

        int count = 0;

        if (root->val >= maxSoFar)
            count = 1;

        maxSoFar = max(maxSoFar, root->val);

        count += dfs(root->left, maxSoFar);
        count += dfs(root->right, maxSoFar);

        return count;
    }

    int goodNodes(TreeNode* root) {
        return dfs(root, root->val);
    }
};