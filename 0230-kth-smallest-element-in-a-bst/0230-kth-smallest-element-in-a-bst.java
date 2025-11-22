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

// LeetCode : 230
class Solution {
    int ans=0;
    int cnt=0;
    // Thursday, January 2, 2025 2:24:34 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
    public int kthSmallest(TreeNode root, int k) {
       bstIterativeApproach(root,k); 
       //return ans;
       
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
       bstHeapApproach(root,k,pq);
       return pq.peek();
    }

    // Does it Matter? Min or Max ?
    // Pre/Post/In-Order
    private void bstHeapApproach(TreeNode node, int k,PriorityQueue<Integer> pq){
        if(node==null) return;        
        
        pq.offer(node.val);
        if(pq.size()>k) pq.poll();
        
        bstHeapApproach(node.left,k,pq);
        bstHeapApproach(node.right,k,pq);    
    }

    // InOrder as it is Sorted
    public void bstIterativeApproach(TreeNode root, int k) {
        if(root==null||k==0) return;
        bstIterativeApproach(root.left,k);
        cnt++;
        if(cnt==k){
            ans=root.val;
        }        
        bstIterativeApproach(root.right,k);        
    }
}