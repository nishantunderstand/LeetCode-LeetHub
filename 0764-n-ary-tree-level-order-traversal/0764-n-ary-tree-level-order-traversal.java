/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// LeetCode 429

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // return levelOrderForEach(root);
        return levelOrderfor(root);
    }

    public List<List<Integer>> levelOrderfor(Node root) {
        Queue<Node> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        que.offer(root);

        while (!que.isEmpty()) {
            int levelLen = que.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < levelLen; i++) {
                Node nodeElem = que.poll();
                curr.add(nodeElem.val);
                for(int j=0;j<nodeElem.children.size();j++){
                    if(nodeElem.children.get(j)!=null){
                        que.offer(nodeElem.children.get(j));
                    }
                }
            }
            res.add(curr);
        }
        return res;
    }


    // Monday, February 10, 2025 2:20:19 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public List<List<Integer>> levelOrderForEach(Node root) {
        Queue<Node> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        que.offer(root);

        while (!que.isEmpty()) {
            int levelLen = que.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < levelLen; i++) {
                Node nodeElem = que.poll();
                curr.add(nodeElem.val);
                for (Node child : nodeElem.children) {
                    if (child != null) {
                        que.offer(child);
                    }
                }
            }
            res.add(curr);
        }
        return res;
    }
}