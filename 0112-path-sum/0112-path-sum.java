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
// LeetCode : 112
/**
| Bitwise OR  : No Short Circuit, Evaluate Both Side
|| Logical OR : Short-Circuit 
*/
class Solution {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfsApproach1(root,targetSum);
        //return hasPath(root,targetSum);
    }

    // Friday, February 7, 2025 7:58:18 PM
    // Time Complexity:O(n) | Space Complexity:O(HeightOfTree)    
    public boolean dfsApproach1(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null && root.val == targetSum) return true;
        boolean leftSum = hasPathSum(root.left,targetSum-root.val);
        boolean rightSum = hasPathSum(root.right,targetSum-root.val);
        //return leftSum | rightSum; //<- BITWISE OR // WRONG 
        return leftSum || rightSum; //<- Logical OR // Correct
    }


    public static boolean hasPath(TreeNode root, int sum){			
		if(root==null) return false;
		int remainingSum = sum - root.val;		
		// Leaf Node 
		if(root.left==null && root.right==null) return remainingSum==0;
		// Child Node
		return hasPath(root.left,remainingSum) || hasPath(root.right,remainingSum);
	}
}