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
 General Edge Case 
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        HashSet<Integer> hs = new HashSet<>();
        return findTargetUtil(root,k,hs);
    }
    public boolean findTargetUtil(TreeNode node, int target,HashSet<Integer> hs){
        if(node==null){
            return false;
        }
        if(hs.contains(target-node.val)){
            return true;
        }
        hs.add(node.val);
        return findTargetUtil(node.left,target,hs) || findTargetUtil(node.right,target,hs);
    }
}