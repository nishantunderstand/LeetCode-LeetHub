/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        //return dfsRecursive(root);
        return bfsIterative(root);
    }

    public int bfsIterative(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int level=0;
        while(!que.isEmpty()){
            int size = que.size();
            
            for(int i=0;i<size;i++){
                TreeNode node = que.poll();
                if(node.left!=null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
            }

            level++;
        }
        return level;
    }


    public int dfsRecursive(TreeNode root) {
        if(root==null) return 0;
        int left=dfsRecursive(root.left);
        int right=dfsRecursive(root.right);
        return Math.max(left,right)+1;
    }

}