// Thursday, May 14, 2026 9:24:22 PM
// LeetCode : 54
// Square Or Rectangle 
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd=matrix.length-1; 
        int colEnd=matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            
            // Traverse Right
            for(int j=colBegin;j<=colEnd;j++){
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for(int i=rowBegin;i<=rowEnd;i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            // TraverseLeft
            if(rowBegin<=rowEnd){
                for(int j=colEnd;j>=colBegin;j--){
                res.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            
            if(colBegin<=colEnd){
            // TraverseUp
            for(int i=rowEnd;i>=rowBegin;i--){
                res.add(matrix[i][colBegin]);
            }
            colBegin++;
            }
            
        }
        return res;
    }
}