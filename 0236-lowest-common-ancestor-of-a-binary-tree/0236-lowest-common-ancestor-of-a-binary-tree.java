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
        //return bruteForce(root,p,q);
        return bruteForceBetter(root,p,q);
    }
    
    // Cleaner and much better
    public TreeNode bruteForceBetter(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;     
        TreeNode left = bruteForceBetter(root.left,p,q);
        TreeNode right = bruteForceBetter(root.right,p,q);        
        if(left!=null && right!=null){
            return root;
        }
        return left!=null?left:right;
    }



    // Saturday, January 4, 2025 5:57:48 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
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