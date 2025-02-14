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
// LeetCode 110
class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHeight(root);
    }

    // Friday, February 14, 2025 3:25:23 PM
    // Time Complexity:O(n^2) | Space Complexity:O(HeightOfTree)
    // Time Complexity: O(n^2) in the worst case (skewed tree), O(n log n) in a balanced tree
    public boolean isBalancedHeight(TreeNode root) {
        if(root==null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(lh-rh<-1 || lh-rh>1) return false;
        //if(Math.abs(lh-rh)<1) return true; // WRONG CODE

        //if(Math.abs(lh-rh)>1) return false; 
        return isBalancedHeight(root.left) && isBalancedHeight(root.right);
    }
  

    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public int height(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }


    // |lh-rh| < 1 


    public boolean isBalancedHeightWRONG(TreeNode root) {
        if(root==null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh-rh<-1 || lh-rh>1) return false;
        return true;
    }

    public boolean isBalancedApproachWRONG(TreeNode root) {
        if(root==null) return true;
        if(root.left!=null) return false;
        if(root.right!=null) return false;
        if(root.left!=null && root.right!=null) return true;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return left && right;
    }
}