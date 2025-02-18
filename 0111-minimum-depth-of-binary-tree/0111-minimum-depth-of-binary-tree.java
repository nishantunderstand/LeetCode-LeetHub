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

/**LeetCode 111
How different From 104. Maximum Depth of Binary Tree
Difference from 104 (Maximum Depth of Binary Tree): 
104 finds the longest path, using Math.max(left, right) + 1.
111 finds the shortest path to a leaf, so we need to handle cases where one child is missing. // <--
*/

// Same as LEETCODE 104

class Solution {
    public int minDepth(TreeNode root) {
        //return dfs(root);
        //return dfsReadable(root);
        //return bfs(root);
        //return minDepthByArchit(root);
        return minDepthGFG(root);
    }

    public int minDepthGFG(TreeNode root) {
        if(root==null) return 0;
        if(root.left == null && root.right == null) return 1; // Leaf Node;
        if(root.left == null) return 1 + minDepthGFG(root.right); 
        if(root.right==null) return 1 + minDepthGFG(root.left); 
        return 1+ Math.min(minDepthGFG(root.left),minDepthGFG(root.right));        
    }

    // THIS CODE IS WRONG FOR SINGLE CHILD
    public int minDepthByArchit(TreeNode root) {
        if(root==null) return 0;
        return 1 + Math.min(minDepthByArchit(root.left),minDepthByArchit(root.right));
    }

    public int dfsReadable(TreeNode root) {
        if(root==null) return 0;
        int left = dfs(root.left);
        int right =dfs(root.right);
        if(root.left==null) return right+1;
        if(root.right==null) return left+1;
        return 1+ Math.min(left,right); 
    }


    // More Inutitive & Better
    // Sunday, February 9, 2025 7:13:34 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public int dfs(TreeNode root) {
        if(root==null) return 0;

        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);

        if(root.left==null) return right;
        if(root.right==null) return left;

        return Math.min(left,right);
    }


    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public int bfs(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth=0;
        while(!que.isEmpty()){
            int queLen = que.size();            
            for(int i=0;i<queLen;i++){
                TreeNode node = que.poll();
                if(node.left==null && node.right==null) return depth;
                if(node.left!=null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}