class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];

        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i%n]>=st.peek()){
                st.pop();
            }
            if(i<n){
                res[i] = st.isEmpty()?-1:st.peek();
            }

            st.push(nums[i%n]);
        }   
        return res;
    }
}

// Monday, June 15, 2026 10:18:01 PM
// TC : O(4n) | SC : O(2n)
// LeetCode : 503