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

    public boolean isBalancedHeight(TreeNode root) {
        if(root==null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh-rh<-1 || lh-rh>1) return false;
        return isBalancedHeight(root.left) && isBalancedHeight(root.right);
    }

    public boolean isBalancedHeightWRONG(TreeNode root) {
        if(root==null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh-rh<-1 || lh-rh>1) return false;
        return true;
    }

    public int height(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
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