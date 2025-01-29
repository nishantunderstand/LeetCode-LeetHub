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
    public List<Integer> postorderTraversal(TreeNode root) {
        return recursiveApproach(root);
    }
    // Wednesday, January 29, 2025 8:31:01 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public List<Integer> recursiveApproach(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        if (root == null) {
            return al;
        }
        postorderTraversalHelper(root, al);
        return al;
    }

    // LRD
    private void postorderTraversalHelper(TreeNode root, List<Integer> al) {
        if (root == null) {
            return;
        }
        postorderTraversalHelper(root.left, al);
        postorderTraversalHelper(root.right, al);
        al.add(root.val);
    }
}