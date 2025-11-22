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
    public int kthSmallest(TreeNode root, int k) {
       bstIterativeApproach(root,k); 
       //return ans;
       
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
       bstHeapApproach(root,k,maxHeap);
       return maxHeap.peek();
    }

    // Pre/Post/In-Order : Doesn't Matter  //<--
    // Saturday, November 22, 2025 11:40:14 AM
    // Time Complexity:O(n logk) | Space Complexity:O(k+HeightOfTree)
    private void bstHeapApproach(TreeNode node, int k,PriorityQueue<Integer> maxHeap){
        if(node==null) return;                                
        bstHeapApproach(node.left,k,maxHeap);            
        bstHeapApproach(node.right,k,maxHeap);         
        maxHeap.offer(node.val);
        if(maxHeap.size()>k) maxHeap.poll();   
    }
    
    // Thursday, January 2, 2025 2:24:34 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)
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