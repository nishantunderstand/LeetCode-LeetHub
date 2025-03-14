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

// Leetcode : 951
// Tuesday, December 31, 2024 10:53:49 AM
// Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val !=root2.val) return false;
        boolean withoutFlip = flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right);
        boolean withFlip = flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left);
        return withoutFlip || withFlip; // Should this be && ?
    }

}

/**
Thinking of Swapping Only One Root is not good. Drop the Idea.
That's different Question
*/