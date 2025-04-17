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

// Leetcode : 559
class Solution {
    public int maxDepth(Node root) {
        return dfsApproach(root);
        //return bfsApproach(root);
    }

    private int dfsApproach(Node root){
        if(root==null) return 0;
        int maxDepth = 0;
        for(Node child : root.children){
            maxDepth =  Math.max(maxDepth, dfsApproach(child));
        }
        return maxDepth+1;
    }

    // Tuesday, February 18, 2025 9:33:20 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public int bfsApproach(Node root){
        if(root==null) return 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int height=0;
        while(!que.isEmpty()){
            int queSize = que.size();

            for(int i=0;i<queSize;i++){            
                Node currentNode = que.poll();
                // How to Add Node
                for(Node child : currentNode.children){
                    que.offer(child);
                }                
            }            
            height++; // After Processing All the Nodes at current Level
        }
        return height;
    }
}