// LeetCode 106
// How Different From LeetCode
class Solution {    
    // Global Variable
    private HashMap<Integer,Integer> inOrderMap;
    private int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        
        // HashMap Approach
        inOrderMap = new HashMap<>();
        postIdx=postorder.length-1; //<--
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        //return hashMapApproach(postorder,0,inorder.length-1);
        
        // Recursive Approach
        return constructTreeRecursion(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    // Time Complexity:O(n) | Space Complexity:O(n)
    public TreeNode hashMapApproach(int[] post,int inBeg,int inEnd){
        if(inBeg>inEnd) return null;

        int rootVal = post[postIdx--]; //<--
        
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inOrderMap.get(rootVal);

        root.right=hashMapApproach(post,rootIdx+1,inEnd); //<--
        root.left=hashMapApproach(post,inBeg,rootIdx-1); 
        
        return root;
    }

    // Monday, February 10, 2025 4:27:34 PM
    // Time Complexity:O(n^2) | Space Complexity:O(n)
    public TreeNode constructTreeRecursion(int[] post,int postBeg,int postEnd,int[] in,int inBeg,int inEnd){
        if(postBeg>postEnd || inBeg>inEnd) return null;   

        TreeNode root = new TreeNode(post[postEnd]);
        int rootidx = findIdx1(in,root.val);
        int leftSize = rootidx-inBeg; //<--

        root.right = constructTreeRecursion(post,postBeg+leftSize,postEnd-1,in,rootidx+1,inEnd); //<--
        root.left = constructTreeRecursion(post,postBeg,postBeg+leftSize-1,in,inBeg,rootidx-1); //<--        
        return root;
    }
    // Time Complexity:O(n) | Space Complexity:O(1)    
    public int findIdx1(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }
}