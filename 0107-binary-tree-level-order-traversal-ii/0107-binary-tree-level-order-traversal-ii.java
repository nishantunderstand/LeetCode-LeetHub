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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //return levelOrderBottomApproach(root);
        //return levelOrderBottomApproachModified(root);
        return levelOrderBottomApproachEducativeIO(root);
    }

    public List<List<Integer>> levelOrderBottomApproachEducativeIO(TreeNode root) {
        
        List<List<Integer>> res = new LinkedList<>(); //<--
        
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize); //<--
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = que.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) que.offer(currentNode.left);
                if (currentNode.right != null) que.offer(currentNode.right);
            }
            res.add(0,currentLevel);
        }
        return res;
    }


    // Monday, February 10, 2025 1:37:30 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public List<List<Integer>> levelOrderBottomApproachModified(TreeNode root) {
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
            res.addFirst(curr);
        }
        //Collections.reverse(res);
        return res;
    }

    // Saturday, February 1, 2025 1:10:30 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public List<List<Integer>> levelOrderBottomApproach(TreeNode root) {
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
            res.addLast(curr);
            //res.add(curr);
        }
        Collections.reverse(res);
        return res;
    }
}