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

// LeetCode 637
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        return averageOfLevelsByEducativeIO(root);
    }
    
    // Friday, February 14, 2025 2:21:37 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public List<Double> averageOfLevelsByEducativeIO(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        if(root==null) return result;
        que.offer(root);
        while(!que.isEmpty()){
            int levelSize = que.size();
            double currentLevelSum = 0;
            for(int i=0;i<levelSize;i++){
                TreeNode currentNode = que.poll();
                currentLevelSum +=currentNode.val;

                if(currentNode.left!=null) que.offer(currentNode.left);
                if(currentNode.right!=null) que.offer(currentNode.right);
            }
            result.add(currentLevelSum/levelSize);
        }
        return result;
    }
}