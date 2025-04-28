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
// Leetcode : 98
class Solution {
    public boolean isValidBST(TreeNode root) {
        //return rangeApproach(root);// FAILING 
        return inOrderApproach(root);
    }


    public boolean rangeApproach(TreeNode root) {
        // Root Null
        if(root==null){
            return true;
        }
        /** 
        // Single Child
        if(root.left==null && root.right==null){
            return true;
        }
        */
        return rangeApproachUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean rangeApproachUtil(TreeNode node,int min,int max){
        // Leaf Node
        if(node==null){
            return true;
        }
        // Should I consider Equality Case Or Not ?
        if(node.val>max || node.val<min){
            return false;
        }
        return rangeApproachUtil(node.left,min,node.val) && 
            rangeApproachUtil(node.right,node.val,max);
    }


    public boolean inOrderApproach(TreeNode root) {
        if(root==null){
            return true;
        }
        // Find InOrder
        ArrayList<Integer> check = inorder(root);
        // Check For Strictly Increasing 
        int n = check.size();
        for(int i=0;i<n-1;i++){
            if(check.get(i)>=check.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> inorder (TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        inorderHelper(root,res);
        return res;
    }
    
    // LDR
    public void inorderHelper(TreeNode root, ArrayList<Integer> res){
        if(root==null){
            return;
        }
        inorderHelper(root.left,res);
        res.add(root.val);
        inorderHelper(root.right,res);
    }
}