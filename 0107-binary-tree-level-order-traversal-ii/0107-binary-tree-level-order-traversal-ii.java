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


// Saturday, February 1, 2025 1:10:30 PM
// Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        que.offer(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = que.poll();
                curr.add(node.val);
                if (node.left != null)
                    que.offer(node.left);
                if (node.right != null)
                    que.offer(node.right);
            }
            res.add(curr);
        }
        Collections.reverse(res);
        return res;

    }
}