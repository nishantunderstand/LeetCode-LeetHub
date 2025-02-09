//LeetCode 628
class Solution {
    public int maximumProduct(int[] nums) {
        //return heapApproach(nums);
        return sortingApproach(nums);

    }
    // Sunday, February 2, 2025 9:39:33 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(1)
    public int sortingApproach(int[] nums) {
        int len = nums.length;
        if(nums==null || len<3) return 0;
        Arrays.sort(nums);
        // Option 1: Three Largest Numbers
        int op1 = nums[len-1] * nums[len-2] * nums[len-3];
        // Option 2: Two Smallest Negatives + Largest Positive
        int op2 = nums[0] * nums[1] * nums[len-1];
        return Math.max(op1,op2);
    }

    //INCORRECT ONE
    //Doesn't handle Negative Element
    public int heapApproach(int[] nums) {
        int len = nums.length;
        if(nums==null || len<3) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());        
        int maxProd = Integer.MIN_VALUE;
        
        for(int i=0;i<len;i++){
            pq.offer(nums[i]);
            if(pq.size()>3) pq.poll();
        
            if(pq.size()==3){
                Iterator<Integer> it = pq.iterator();
                int a = it.next();
                int b = it.next();
                int c = it.next();
                int currProd = a*b*c;
                maxProd = Math.max(currProd,maxProd);
            }
        }
        return maxProd;
    }
}