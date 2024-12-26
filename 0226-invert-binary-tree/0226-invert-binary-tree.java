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
    public TreeNode invertTree(TreeNode root) {
        return invertTreeRecursive(root);
    }

    // Thursday, December 26, 2024 2:33:53 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public TreeNode invertTreeRecursive(TreeNode root) {
        if(root==null) return root;

        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        
        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);
        return root;
    }
}