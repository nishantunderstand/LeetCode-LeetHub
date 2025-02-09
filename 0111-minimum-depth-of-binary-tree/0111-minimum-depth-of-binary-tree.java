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
// LeetCode 111
// How different From 104. Maximum Depth of Binary Tree
class Solution {
    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if(root==null) return 0;

        int left = 1 + dfs(root.left);
        int right = 1+ dfs(root.right);
        
        if(root.left==null) return right;
        if(root.right==null) return left;

        return Math.min(left,right);
    }
}