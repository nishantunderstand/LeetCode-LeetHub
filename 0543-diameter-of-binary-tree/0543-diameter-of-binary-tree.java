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
    // int maxi=0;    
    public int diameterOfBinaryTree(TreeNode root) {
        dfsRecursive(root);
        return maxi;
    }
    
    int maxi=0;  
    
    // Monday, December 30, 2024 10:11:23 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public int dfsRecursive(TreeNode root) {
        if(root==null) return 0;        
        int leftHeight = dfsRecursive(root.left);
        int rightHeight = dfsRecursive(root.right);
        maxi = Math.max(maxi,leftHeight+rightHeight);
        return 1+ Math.max(leftHeight,rightHeight);
    }
}