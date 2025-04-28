/**
Histogram Question
*/
// Leetcode : 85
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(n==0||m==0){
            return 0;
        }
        int[] height = new int[m]; // Based on Columns Not On Rows
        int maxArea = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            int area = maxAreaHistogram(height);
            maxArea = Math.max(area,maxArea);            
        }
        return maxArea;        
    }

    // On Index 
    public int maxAreaHistogram(int[] heights){
        int n = heights.length;
        if(heights==null||n==0){
            return 0;
        }
        int[] nseL = new int[n];
        int[] nseR = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            nseL[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            nseR[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            int width = (nseR[i]-1)-(nseL[i]+1) +1; // You can modify it as well.
            int area  = heights[i]*width;
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;        
    }
}