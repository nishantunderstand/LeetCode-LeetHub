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
    // Sunday, December 15, 2024 7:56:13 PM
    // Time Complexity:O(HeightOfTree) | Space Complexity:O(n)
    public List<Integer> queueApproach(TreeNode root) {        
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;    
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);        
        while(!que.isEmpty()){
            int levelSize = que.size();                                
            for(int i=1;i<=levelSize;i++){
                TreeNode node = que.poll();
                if(i==levelSize){
                    res.add(node.val);
                }
                if(node.left!=null)que.offer(node.left);                
                if(node.right!=null) que.offer(node.right);                
            }
        }
        return res;
    }
}