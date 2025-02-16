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

// Try LeetCode : 101

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {        
        // if(p==null || q==null) return false; // <-- THIS WILL GENERATE ERROR 
        /**
        It does not check if both p and q are null.
        If both are null, the correct answer should be true, but this line incorrectly returns false.
        */
        if(p==null && q==null) return true;
        if(p==null || q==null) return false; 
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}