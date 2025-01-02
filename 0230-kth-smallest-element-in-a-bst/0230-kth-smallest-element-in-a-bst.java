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
    int ans=-1;
    int cnt=0;
    public int kthSmallest(TreeNode root, int k) {
       bstIterativeApproach(root,k); 
       return ans;
    }

    // InOrder as it is Sorted
    public void bstIterativeApproach(TreeNode root, int k) {
        if(root==null||k==0) return;
        bstIterativeApproach(root.left,k);
        cnt++;
        if(cnt==k){
            ans=root.val;
        }        
        bstIterativeApproach(root.right,k);
        
    }
}