class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        if(temperatures==null|| n==0){
            return res;
        }
        // Next Greate on Right on Index , WARMER
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }
            res[i]=st.isEmpty()?0:st.peek()-i;
            st.push(i);
        }
        return res;
    }
}