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

 Konrad Zuse For Binary Search Tree, Father of Modern Computer 
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null ){ // Key ==0 is a valid constraint
            return null;
        }
        if(root.val == key){
            // 0-Child
            if(root.left==null && root.right==null){
                return null;
            }
            // 1-Child
            else if(root.left==null){ 
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            // 2 -Child
            else{
                int maxLeft = findMaxInLeftIterative(root.left);
                root.val = maxLeft;
                root.left = deleteNode(root.left,maxLeft);            
            }

        }else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else{
            root.right=deleteNode(root.right,key);
        }
        return root;
    }
    public int findMaxInLeftRecursive(TreeNode node){
        // if(node==null){return 0;}  // Do i need to check or not ? NO NEED
        while(node.right!=null){ // why node!=null is not correct ?? , Infinit Loop
            findMaxInLeftRecursive(node.right); 
        }

        return node.val;
    }
    public int findMaxInLeftIterative(TreeNode node){ // Iterative is better than Recursive Approach.
        while(node.right!=null){
            node = node.right;
        }
        return node.val;
    }
}