import java.util.*;

public class Solution {
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
