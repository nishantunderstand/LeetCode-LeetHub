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

// Leetcode : 113
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(root,targetSum,curr,res);
        return res;
    }

    // Friday, February 21, 2025 7:12:55 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public void dfs(TreeNode root,int target,List<Integer> curr,List<List<Integer>> res){
        if(root==null) return;
        
        // Leaf Node | Multiple Possible Answer
        if(root.left==null && root.right==null && root.val==target){
            curr.add(root.val);
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return;
        }

        curr.add(root.val);
        dfs(root.left,target-root.val,curr,res);
        dfs(root.right,target-root.val,curr,res);
        curr.remove(curr.size()-1);
    }
}