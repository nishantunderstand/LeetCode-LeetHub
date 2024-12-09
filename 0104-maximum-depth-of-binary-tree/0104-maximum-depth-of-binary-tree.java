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
        return recursiveSolmaxDepth(root);
    }
    public int recursiveSolmaxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh = recursiveSolmaxDepth(root.left);
        int rh = recursiveSolmaxDepth(root.right);
        return 1+Math.max(lh,rh);
    }
}