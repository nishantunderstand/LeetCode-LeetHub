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
    // Global Variable
    private HashMap<Integer,Integer> inOrderMap;
    private int preIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {        
        // HashMap Approach
        inOrderMap = new HashMap<>();
        preIdx=0; //<--
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        //return hashMapApproach(preorder,0,inorder.length-1);

        // RecursiveApproach
        return constructTreeRecursion(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    // Time Complexity:O(n) | Space Complexity:O(n)
    public TreeNode hashMapApproach(int[] pre,int inBeg,int inEnd){
        if(inBeg>inEnd) return null;

        int rootVal = pre[preIdx++]; //<--
        
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inOrderMap.get(rootVal);

        root.left=hashMapApproach(pre,inBeg,rootIdx-1);
        root.right=hashMapApproach(pre,rootIdx+1,inEnd); //<--
        return root;
    }

    // Monday, February 10, 2025 4:27:34 PM
    // Time Complexity:O(n^2) | Space Complexity:O(n)
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
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int findIdx(int[] arr,int start,int end,int target){
        for(int i=start;i<=end;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }
    // Time Complexity:O(n) | Space Complexity:O(1)    
    public int findIdx1(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }
}