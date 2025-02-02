class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        
        // If the size of the heap exceeds k, remove the smallest elements
        while (pq.size()>k){
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */