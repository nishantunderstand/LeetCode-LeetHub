// Leetcode : 867
class Solution {
    public int[][] transpose(int[][] matrix) {        
        return outOfPlaceApproach(matrix);
        //return inPlaceApproach(matrix);
    }

    // Thursday, March 20, 2025 8:32:27 PM
    // T.C - O(row*col) | S.C - O(1)
    // For Square Matrix Only
    public int[][] inPlaceApproach(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(matrix==null || row==0||col==0) return new int[0][0];
        
        // Handle Rectangle Matrix
        if(row!=col) return outOfPlaceApproach(matrix);

        // Upper Half
        // InPlace Transpose For Square Matrix
        for(int i=0;i<row;i++){
            for(int j=i+1;j<col;j++){ //<--
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }


    // Friday, November 15, 2024 8:56:58 PM
    // T.C - O(row*col) | S.C - O(row*col)
    // For Square & Rectangle Matrix
    public int[][] outOfPlaceApproach(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(matrix==null || row==0||col==0) return new int[0][0];
        int[][] res = new int[col][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                res[j][i]=matrix[i][j];
            }
        }
        return res;
    }
}