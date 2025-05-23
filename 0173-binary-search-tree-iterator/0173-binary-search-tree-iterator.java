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
// Leetcode : 173
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        // st.push(root); // Why Rutime Error ?
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        pushAllLeft(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    // Iterative Approach
    public void pushAllLeft(TreeNode node){
        while(node!=null){
            st.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */