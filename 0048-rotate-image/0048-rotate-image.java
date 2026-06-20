// Thursday, May 14, 2026 9:08:30 PM
// LeetCode : 48
class Solution {
    public void rotate(int[][] matrix) {
        // Transpose && Reverse 
        // Transpose 
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Row by Row Reverse
        for(int i=0;i<n;i++){
            int left = 0;
            int right = n-1;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }       
    }
}