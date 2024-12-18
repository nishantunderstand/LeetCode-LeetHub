class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // return bruteForce(matrix, target);
        // return optimizedByCornerSearch(matrix, target);
        return binarySearchApproach(matrix, target);
    }

    // Wednesday, December 18, 2024 1:58:27 PM
    // Time Complexity:O(log(m*n) | Space Complexity:O(1)
    // Do i need to flatten a Matrix then Search ?
    public boolean binarySearchApproach(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row*col-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;

            if(matrix[mid/col][mid%col]==target){
                return true;
            }
            else if(matrix[mid/col][mid%col]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }


    // Wednesday, December 18, 2024 1:31:25 PM
    // Time Complexity:O(m+n) | Space Complexity:O(1)
        // Top Right Corner (0,col-1)
        // When you change Corner, You need to modify the codebase as well.
    public boolean optimizedByCornerSearch(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
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
