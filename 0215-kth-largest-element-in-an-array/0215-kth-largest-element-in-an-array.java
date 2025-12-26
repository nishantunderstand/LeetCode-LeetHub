// LeetCode : 215
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // return arrayApproach(nums,k);
        // return maxHeapApproach(nums,k);
        //return minHeapApproach(nums,k); 
        return bruteForceApproach(nums,k);      
    }


    // [3,2,1,5,6,4], k = 2
    // [1,2,3,4,5,6] 
    // kth largest → n - k
    private int bruteForceApproach(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    
    // Thursday, February 13, 2025 8:18:52 PM
    // Time Complexity:O(n*logk) | Space Complexity:O(k)
    public int minHeapApproach(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = nums.length;
        if(k>n) return 0;
        for(int i=0;i<n;i++){
            minHeap.offer(nums[i]);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    // Sunday, December 22, 2024 4:07:12 PM
    // Time Complexity:O((n+k)logn) | Space Complexity:O(n)
    public int maxHeapApproach(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Time Complexity:O(nlogn) | Space Complexity:O(1)
        for(int i:nums){
            maxHeap.offer(i);
        }
        int res=0;
        // Time Complexity:O(klogn) | Space Complexity:O(1)
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