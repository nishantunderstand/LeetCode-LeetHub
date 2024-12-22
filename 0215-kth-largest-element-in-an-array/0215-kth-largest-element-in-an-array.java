class Solution {
    public int findKthLargest(int[] nums, int k) {
        // return arrayApproach(nums,k);
        return maxHeapApproach(nums,k);
    }

    // Sunday, December 22, 2024 4:07:12 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(n)
    public int maxHeapApproach(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Time Complexity:O(nlogn) | Space Complexity:O(1)
        for(int i:nums){
            maxHeap.offer(i);
        }
        int res=0;
        // Time Complexity:O(nlogn) | Space Complexity:O(1)
        while(k>0){
            res=maxHeap.poll();
            k--;
        }
        return res;
    }

    // Sunday, December 22, 2024 4:02:40 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(1)
    public int arrayApproach(int[] nums, int k) {
        int n = nums.length;
        if(k>n){
            return 0;
        }
        Arrays.sort(nums);
        return nums[n-k];
    }
}