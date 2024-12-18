class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return bruteForce(matrix, target);
        //return optimized(matrix, target);
    }

    public boolean optimized(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1;
        int j = 0;

        while (i >= 0 && j < col) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

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
