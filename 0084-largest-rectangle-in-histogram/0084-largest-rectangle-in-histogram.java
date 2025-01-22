class Solution {
    public int largestRectangleArea(int[] heights) {
        // By Default Width is 1 , If it had different, We need to take into Account.        
        int n = heights.length;
        if(n==0){
            return 0;
        }
        int[] nseLeft = new int[n];
        int[] nseRight = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        // Next Smaller On Left, -1 , Index , Smaller mean Pop All Large Element, Left Side -1
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            nseLeft[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        // st = new ArrayDeque<>();  // Okay Approach.
        st.clear(); // Better Approach
        // Next Smaller Right Side, n , Smaller Pop All Large Element , Right Side Meand Large element is n
            for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            nseRight[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int maxArea = 0;
        // nseLeft+1 , nseRight-1
        for(int i=0;i<n;i++){
            //int width = (nseRight[i]-1) - (nseLeft[i]+1)+1; // You can remove Extra make it clear
            int width = nseRight[i]-1-nseLeft[i]; // You can remove Extra make it clear
            int area = heights[i]*width; // Why this line is Important
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}