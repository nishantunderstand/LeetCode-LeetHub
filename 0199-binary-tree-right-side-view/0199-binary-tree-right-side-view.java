// Leetcode : 199
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
        //return rightSideViewRecursive(root);
        //return queueApproach(root);
        return queueApproachRightFirst(root);
    }


    public List<Integer> queueApproachRightFirst(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int levelSize = que.size();
            for(int i=0;i<levelSize;i++){
                TreeNode node = que.poll();
                if(i==0) res.add(node.val);
                if(node.right!=null) que.offer(node.right);
                if(node.left!=null) que.offer(node.left); //<--
            }
        }
        return res;
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
                if(i==levelSize) res.add(node.val);                
                if(node.left!=null)que.offer(node.left);   //<--               
                if(node.right!=null) que.offer(node.right);                
            }
        }
        return res;
    }



    // Thursday, February 6, 2025 9:12:03 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        rideSideViewUtil(root,result,0);
        return result;
    }
    // D | LR
    public void rideSideViewUtil(TreeNode curr,List<Integer> result,int currDepth){
        if(curr==null){
            return;
        }
        if(currDepth==result.size()){
            result.add(curr.val);
        }
        rideSideViewUtil(curr.right,result,currDepth+1);
        rideSideViewUtil(curr.left,result,currDepth+1);
    }
}