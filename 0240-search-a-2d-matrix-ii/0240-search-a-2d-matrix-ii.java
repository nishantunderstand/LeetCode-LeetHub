// Leetcode : 240
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return stairCaseSearch(matrix,target);        
    }

    // Thursday, April 17, 2025 10:57:13 PM
    // Time Complexity:O(m+n) | Space Complexity:O(1)
    private boolean stairCaseSearch(int[][] mat,int k){
        int row = 0, col = mat[0].length-1;
        while(row<mat.length && col>=0){
            if(mat[row][col]==k){
                return true;
            }
            else if(mat[row][col]>k){
                col--;
            }
            else if(mat[row][col]<k){
                row++;
            }            
        }
        return false;
    }
}

