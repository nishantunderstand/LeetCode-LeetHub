class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //return bruteForce(matrix, target);
        return optimized(matrix, target);
    }

    // Wednesday, December 18, 2024 1:31:25 PM
    // Time Complexity:O(n^2 n nlogn n √n 2^n  HeightOfTree) | Space Complexity:O(1 n HeightOfTree)
    // Top Right Corner
    public boolean optimized(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col-1;

        while (i<row && j>=0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    // Wednesday, December 18, 2024 1:31:21 PM
    // Time Complexity:O(n^2) | Space Complexity:O(1)
    public boolean bruteForce(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
