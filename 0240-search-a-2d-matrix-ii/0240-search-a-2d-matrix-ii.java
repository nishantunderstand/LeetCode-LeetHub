// Leetcode : 240

/**
Can we Apply Flatten Approach ? NO
Brute Force Search Approach 
Binary Search Approach
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearchApproach(matrix,target);        
    }

    private boolean binarySearchApproach(int[][] mat,int k){
        int row = 0, col = mat[0].length-1;

        while(row<mat.length && col>=0){
            if(mat[row][col]==k) return true;
            else if(mat[row][col]>k) col--;
            else row++;
        }
        return false;
    }
}

