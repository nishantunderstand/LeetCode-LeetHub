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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int ans =  maxDepthHelper(root);   
        return ans;    
    }
    public int maxDepthHelper(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh = maxDepthHelper(root.left);
        int rh = maxDepthHelper(root.right);
        return Math.max(lh,rh)+1;            
    }
}