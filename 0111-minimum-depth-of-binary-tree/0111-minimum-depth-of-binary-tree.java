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
// Difference from 104 (Maximum Depth of Binary Tree): 
// - 104 finds the longest path, using Math.max(left, right) + 1.
// - 111 finds the shortest path to a leaf, so we need to handle cases where one child is missing. //<--
class Solution {
    public int minDepth(TreeNode root) {
        //return dfs(root);
        return dfsReadable(root);
    }

    public int dfsReadable(TreeNode root) {
        if(root==null) return 0;
        int left = dfs(root.left);
        int right =dfs(root.right);
        if(root.left==null) return right+1;
        if(root.right==null) return left+1;
        return Math.min(left,right)+1; //?? DON"T GET IT
    }


    // More Inutitive 
    // Sunday, February 9, 2025 7:13:34 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public int dfs(TreeNode root) {
        if(root==null) return 0;

        int left = 1 + dfs(root.left);
        int right = 1+ dfs(root.right);

        if(root.left==null) return right;
        if(root.right==null) return left;

        return Math.min(left,right);
    }
}