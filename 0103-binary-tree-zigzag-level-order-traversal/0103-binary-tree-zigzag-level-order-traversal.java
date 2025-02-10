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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zigzagLevelOrderTrueFalse(root);
        //return zigzagLevelOrderToggle(root);
    }
    public List<List<Integer>> zigzagLevelOrderTrueFalse(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        //LinkedList<LinkedList<Integer>> res = new ArrayList<>();        
        if(root==null) return res;        
        que.offer(root);
        boolean LR = true; //<--
        while(!que.isEmpty()){            
            int levelLen = que.size();
            List<Integer> curr = new ArrayList<>();
            for(int i=0;i<levelLen;i++){
                TreeNode node = que.poll();
                if(LR){
                    curr.addLast(node.val);                                     
                }else{
                    curr.addFirst(node.val);
                }                
                if(node.left!=null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
            }
            res.add(curr);
            if(LR){
                LR = false;
            }
            else{
                LR = true;
            }
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrderToggle(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();        
        if(root==null) return res;        
        que.offer(root);
        boolean LR = true; //<--
        while(!que.isEmpty()){            
            int levelLen = que.size();
            List<Integer> curr = new ArrayList<>();
            for(int i=0;i<levelLen;i++){
                TreeNode node = que.poll();
                if(LR){
                    curr.addLast(node.val);                    
                }else{
                    curr.addFirst(node.val);
                }                
                if(node.left!=null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
            }
            res.add(curr);
            LR=!LR; // Toggling IT
            //LR=false; // Setting it False Permantelly
        }
        return res;
    }
}