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

/**
Sunday, November 17, 2024 7:18:34 PM
T.C - O(n^2/nlogn/n/√n/logn/1) | S.C - O(n/1/HeightOfTree)
Verify it, Correct it. Explain it as well.
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //recursiveSolution(root);
        //return iterativeSolution(root);
        return iterativeSolutionWithBreak(root);
    }

    // T.C - O(n) | S.C - O(n+HeightOfTree)
    public List<Integer> iterativeSolutionWithBreak(TreeNode root){
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;       
        while(true){
            if(node!=null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty()){
                    break;                   
                }
                node = st.pop();
                res.add(node.val);
                node = node.right;                               
            }
        }
        return res;
    }

    // T.C - O(n) | S.C - O(n+HeightOfTree)
    public List<Integer> iterativeSolution(TreeNode root){
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        boolean isDone = false; // It is alternative to avoid break Statment.
        while(!isDone){
            if(node!=null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty()){
                    //break;
                    isDone=true; // All nodes processed; exit loop.
                }else{
                    node = st.pop();
                    res.add(node.val);
                    node = node.right;
                }                
            }
        }
        return res;
    }

    // T.C - O(n) | S.C - O(/HeightOfTree)
    public List<Integer> recursiveSolution(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inOrderHelper(root,res);
        return res;
    }
    // LDR
    public void inOrderHelper(TreeNode root,List<Integer> res){
        if(root==null) return;
        inOrderHelper(root.left,res);
        res.add(root.val);
        inOrderHelper(root.right,res);
    }
}