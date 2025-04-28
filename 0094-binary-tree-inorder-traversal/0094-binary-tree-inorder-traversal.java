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

// Leetcode : 94
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;                
        ArrayDeque<TreeNode> st = new ArrayDeque<>();                
        TreeNode curr = root;
        //LDR
        /**
            But Sometime it give me error.
            So the Question is What is the correct Order
            As we know AND OR have Short Circut Property
        */
        while(!st.isEmpty()|| curr!=null){ // Working Fine
        //while(curr!=null || !st.isEmpty()){ // Working Fine
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr = st.pop();
            res.add(curr.val);
            curr=curr.right;
        }
        return res;
    }
}