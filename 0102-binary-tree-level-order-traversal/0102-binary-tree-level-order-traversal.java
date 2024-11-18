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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return queueApproach(root);
    }

    public List<List<Integer>> queueApproach(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int queSize = que.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0;i<queSize;i++){
                TreeNode node = que.poll();
                currLevel.add(node.val);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            res.add(currLevel);
        }
        return res;
    }
}