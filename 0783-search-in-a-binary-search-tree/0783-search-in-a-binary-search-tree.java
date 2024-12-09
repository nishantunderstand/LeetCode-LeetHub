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
    public TreeNode searchBST(TreeNode root, int val) {
        return recursiveSol(root,val);
        //return iterativeSol(root,val);
    }
    
    // T.C - O(HeightOfTree) | S.C - O(1)
    public TreeNode iterativeSol(TreeNode root,int val){        
        while(root!=null){
            if(val==root.val){
                return root;
            }else if(val<root.val){
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return null;
    }

    // T.C - O(HeightOfTree) | S.C - O(HeightOfTree)
    public TreeNode recursiveSol(TreeNode root,int val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }else if(val<root.val){
            return recursiveSol(root.left,val);
        }else{
            return recursiveSol(root.right,val);
        }    
    }
}