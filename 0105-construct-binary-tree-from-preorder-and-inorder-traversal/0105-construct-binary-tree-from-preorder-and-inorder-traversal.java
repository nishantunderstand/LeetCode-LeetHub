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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTreeRecursion(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode constructTreeRecursion(int[] pre,int preBeg,int preEnd,int[] in,int inBeg,int inEnd){
        if(preBeg>preEnd || inBeg>inEnd) return null;        
        TreeNode root = new TreeNode(pre[preBeg]);
        //int rootidx = findIdx(in,inBeg,inEnd,root.val);
        int rootidx = findIdx1(in,root.val);
        int leftSize = rootidx-inBeg; //<--
        root.left = constructTreeRecursion(pre,preBeg+1,preBeg+leftSize,in,inBeg,rootidx-1);
        root.right = constructTreeRecursion(pre,preBeg+leftSize+1,preEnd,in,rootidx+1,inEnd);
        return root;
    }
    public int findIdx(int[] arr,int start,int end,int target){
        for(int i=start;i<=end;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }

    public int findIdx1(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }
}