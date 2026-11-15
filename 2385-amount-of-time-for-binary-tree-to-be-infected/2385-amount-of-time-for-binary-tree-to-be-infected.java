class Solution {
    public int amountOfTime(TreeNode root, int start) {
        // 1. Find TargetNode
        TreeNode target = findTarget(root, start);
        if (target == null)
            return 0; // NOT FOUND CASE 

        // 2. Parent Node
        Map<TreeNode, TreeNode> map = new HashMap<>();
        inOrder(root, map);

        // 2. BFS From Target
        Queue<TreeNode> que = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        que.offer(target);
        visited.add(target);

        int time = 0;

        while (!que.isEmpty()) {
            int n = que.size();
            boolean burned = false;

            while (n-- > 0) {
                TreeNode curr = que.poll();
                // LEFT
                if (curr.left != null && !visited.contains(curr.left)) {
                    que.offer(curr.left);
                    visited.add(curr.left);
                    burned = true;
                }

                // RIGHT
                if (curr.right != null && !visited.contains(curr.right)) {
                    que.offer(curr.right);
                    visited.add(curr.right);
                    burned = true;
                }

                // PARENT
                if (map.containsKey(curr) && !visited.contains(map.get(curr))) {
                    que.offer(map.get(curr));
                    visited.add(map.get(curr));
                    burned = true;
                }
            }
            if (burned) {
                time++;
            }
        }

        return time;
    }

    private void inOrder(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null)
            return;

        if (root.left != null)
            map.put(root.left, root);
        inOrder(root.left, map);

        if (root.right != null)
            map.put(root.right, root);
        inOrder(root.right, map);
    }

    private TreeNode findTarget(TreeNode root, int start) {
        if (root == null)
            return null;
        if (root.val == start) // LeetCode : val || GFG / TUF -> data
            return root;

        TreeNode left = findTarget(root.left, start);
        if (left != null)
            return left;

        TreeNode right = findTarget(root.right, start);
        if (right != null)
            return right;

        return null; // NOT FOUND
    }
}