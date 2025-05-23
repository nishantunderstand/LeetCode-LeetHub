/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Leetcode : 235
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //return bruteForceBT(root,p,q);
        //return lcaBST(root,p,q);
        return lcaCleaner(root,p,q);
    }

    // Wednesday, January 29, 2025 6:35:36 PM
    // Time Complexity:O(H) | Space Complexity:O(HeighthOfTree)
    public TreeNode lcaCleaner(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > Math.max(p.val,q.val)) return lcaCleaner(root.left,p,q);
        if(root.val < Math.min(p.val,q.val)) return lcaCleaner(root.right,p,q);
        return root;
    }

    // Wednesday, January 29, 2025 6:33:35 PM
    // Time Complexity:O(H) | Space Complexity:O(H)
    // H = height of tree, O(logN) balanced, O(N) skewed
    public TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        // Smaller
        if(p.val <root.val && q.val < root.val) return lcaBST(root.left,p,q);
        
        // Greater
        if(p.val >root.val && q.val > root.val) return lcaBST(root.right,p,q);
        
        return root;
    }
    
    // Saturday, January 4, 2025 6:01:39 PM
    // Time Complexity:O(N) | Space Complexity:O(N)
    public TreeNode bruteForceBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(root.val==p.val || root.val==q.val) return root;
        
        TreeNode left=bruteForceBT(root.left,p,q);
        TreeNode right=bruteForceBT(root.right,p,q);

        /** Approach 1     
        if(left!=null && right!=null) return root;
        else if(left!=null)return left;
        else return right;
        */

        // Approach 2
        if(left!=null && right!=null) return root;
        return (left!=null)?left:right;
    }
}