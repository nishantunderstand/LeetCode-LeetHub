class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        return heapApproach(matrix,k);
    }

    // Sunday, February 2, 2025 8:17:02 PM
    // Time Complexity:O(n^2logn) | Space Complexity:O(n)
    public int heapApproach(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int rows = mat.length;
        int cols = mat[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                pq.offer(mat[i][j]);
                if(pq.size()>k) pq.poll();
            }
        }
        return pq.peek();
    }
}
