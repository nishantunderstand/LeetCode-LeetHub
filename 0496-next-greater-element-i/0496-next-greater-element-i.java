// Monday, June 15, 2026 8:35:09 PM
// TC : O(m+n) | SC : O(m)
// LeetCode : 496
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Deque<Integer> st = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>=st.peek()){
                st.pop();
            }

            int nextGreater = st.isEmpty()?-1:st.peek();
            map.put(nums2[i],nextGreater);
            st.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}