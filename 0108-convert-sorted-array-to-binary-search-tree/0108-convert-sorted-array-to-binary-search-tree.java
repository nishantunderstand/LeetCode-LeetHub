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
// Leetcode : 108
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if(n<=0)return null;

        return createBST(nums,0,n-1);
    }
    // Thursday, February 13, 2025 7:50:23 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public TreeNode createBST(int[] nums,int left,int right){
        if(left>right){ return null; }
        
        int mid1 = left + (right-left)/2; // Left Middle
        int mid = left + (right-left+1)/2; // Right Middle
        
        TreeNode root = new TreeNode(nums[mid]);  //<--
        root.left = createBST(nums,left,mid-1);
        root.right = createBST(nums,mid+1,right);
        return root;
    }
}