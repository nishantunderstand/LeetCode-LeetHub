class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Largest => minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size()>k) minHeap.poll();
        }       
        return minHeap.peek();
    }
}
// Thursday, June 11, 2026 7:22:53 PM
// TC : O(nlogk) | SC : O(k)
// LeetCode : 215 