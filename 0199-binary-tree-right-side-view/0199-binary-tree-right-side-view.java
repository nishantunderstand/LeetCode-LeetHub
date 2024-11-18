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
    public List<Integer> rightSideView(TreeNode root) {
        return queueApproach(root);
    }

    // Monday, November 18, 2024 1:59:46 PM
    // T.C - O(n) | S.C - O(n)
    public List<Integer> queueApproach(TreeNode root){
        List<Integer> res = new ArrayList<>(); // SC O(n)
        if(root==null) return res;
        Queue<TreeNode> que = new LinkedList<>(); // SC O(n)
        que.add(root);        
        while(!que.isEmpty()){ // TC O(n)                     
            int queSize = que.size();
            for(int i=0;i<queSize;i++){ // TC O(n) 
                TreeNode node = que.poll();
                if(i==queSize-1){
                    res.add(node.val);
                }
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);                
            }
        }
        return res;
    }
}