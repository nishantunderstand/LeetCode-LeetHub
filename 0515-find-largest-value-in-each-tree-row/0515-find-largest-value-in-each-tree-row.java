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
    public List<Integer> largestValues(TreeNode root) {
        return largestByEducativeIO(root);
    }

    // Friday, February 14, 2025 2:28:13 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public List<Integer> largestByEducativeIO(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while(!que.isEmpty()){
            int levelSize = que.size();
            int maxVal = Integer.MIN_VALUE;
            for(int i=0;i<levelSize;i++){
                TreeNode currentNode = que.poll();
                maxVal = Math.max(maxVal,currentNode.val);
                if(currentNode.left!=null) que.offer(currentNode.left);
                if(currentNode.right!=null) que.offer(currentNode.right);
            }
            res.add(maxVal);
        }
        return res;
    }
}