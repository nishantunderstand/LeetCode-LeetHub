class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols-1;

        while(row<rows && col>=0){
            int index = matrix[row][col];

            if(index==target) return true;

            if(index>target){
                col--; //
            }else{
                row++;
            }
        }
        return false;
    }
}
// Saturday, June 6, 2026 5:54:05 PM
// TC : O(n nlogn) | SC : O(1 n)
// LeetCode : 240