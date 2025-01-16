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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        if(root==null){
            return al;
        }
        preorderTraversalHelper(root,al);
        return al;        
    }
    
    // DLR
    private void preorderTraversalHelper(TreeNode root,List<Integer> al){
        if(root==null){
            return;
        }
        al.add(root.val);
        preorderTraversalHelper(root.left,al);
        preorderTraversalHelper(root.right,al); 
    }
}