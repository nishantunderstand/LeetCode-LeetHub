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

// Monday, December 30, 2024 11:35:51 PM
// Time Complexity:O(n) | Space Complexity:OHeightOfTree)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {        
        // if(p==null || q==null) return false; // <-- THIS WILL GENERATE ERROR ?? WHY ??? 
        if(p==null && q==null) return true;
        if(p==null || q==null) return false; 
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}