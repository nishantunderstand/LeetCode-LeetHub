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
// Leetcode : 226
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // return invertTreeRecursive(root);
        //return invertTreeIterative(root);
        return invertTreeRecursiveMOD(root);
    }

    public TreeNode invertTreeRecursiveMOD(TreeNode root) {
        if(root==null) return root;
        //swap(root.left,root.right);  // WRONG      
        swap(root);      
        invertTreeRecursiveMOD(root.left);
        invertTreeRecursiveMOD(root.right);
        return root;
    }

    public void swap(TreeNode root){
        if(root==null) return;
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
    }

    public void swapWRONG(TreeNode root1,TreeNode root2){
        TreeNode temp = root1;
        root1=root2;
        root2=temp;
    }

    // BFS
    // Sunday, December 29, 2024 12:26:43 AM

    // Time Complexity:O(n) | Space Complexity:O(width of tree)
    public TreeNode invertTreeIterative(TreeNode root) {
        if(root==null) return root;

        Queue<TreeNode> que = new ArrayDeque<>();        
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode curr = que.poll();

            // Swap
            TreeNode temp = curr.left;
            curr.left=curr.right;
            curr.right=temp;

            // Add remaining 
            if(curr.left!=null) que.offer(curr.left);
            if(curr.right!=null) que.offer(curr.right);            
        }
        return root;
    }

    // Thursday, December 26, 2024 2:33:53 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public TreeNode invertTreeRecursive(TreeNode root) {
        if(root==null) return root;

        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        
        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);
        return root;
    }


    
}