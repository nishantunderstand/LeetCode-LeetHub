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
// Leetcode : 543
class Solution {
    int maxi=0;    
    public int diameterOfBinaryTree(TreeNode root) {
        //dfsHeightByNode(root);
        dfsHeightByEdge(root);
        return maxi;

    }

    // Monday, December 30, 2024 11:23:09 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public int dfsHeightByEdge(TreeNode root) {
        if(root==null) return -1;
        int left = dfsHeightByEdge(root.left);
        int right = dfsHeightByEdge(root.right);
        maxi = Math.max(maxi,left+right+2);  //<--
        return 1 + Math.max(left,right);
    }

    // Monday, December 30, 2024 10:11:23 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public int dfsHeightByNode(TreeNode root) {
        if(root==null) return 0;        
        int left = dfsHeightByNode(root.left);
        int right = dfsHeightByNode(root.right);
        maxi = Math.max(maxi,left+right);
        return 1+ Math.max(left,right);  //<--
    }
}