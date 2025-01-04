/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return bruteForce(root,p,q);
    }

    public TreeNode bruteForce(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;

        if(root.val==p.val||root.val==q.val) return root;
        
        TreeNode left = bruteForce(root.left,p,q);
        TreeNode right = bruteForce(root.right,p,q);
        
        if(left!=null && right!=null){
            return root;
        }else if(left!=null){
            return left;
        }else{
            return right;
        }
    }
}