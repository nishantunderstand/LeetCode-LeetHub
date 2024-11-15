/**
Friday, November 15, 2024 8:56:58 PM
T.C - O(row*col)
S.C - O(row*col)
*/


class Solution {
    public int[][] transpose(int[][] matrix) {
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