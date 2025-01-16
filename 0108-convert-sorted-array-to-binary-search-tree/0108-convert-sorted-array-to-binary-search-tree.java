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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if(n<=0){
            return null;
        }
        return createBST(nums,0,n-1);
    }
    public TreeNode createBST(int[] nums,int beg,int end){
        if(beg>end){
            return null;
        }
        int mid = beg + (end-beg)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums,beg,mid-1);
        root.right = createBST(nums,mid+1,end);
        return root;
    }
}