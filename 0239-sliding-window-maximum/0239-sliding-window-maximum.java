// Leetcode : 239
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //return bruteForceApproach(nums, k); // TLE
        return dequeApproach(nums,k);
    }


    // TLE
    // Monday, November 18, 2024 3:56:23 PM
    // T.C - O(n^2) | S.C - O(n)
    public int[] bruteForceApproach(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len <= 0 || k > len) return new int[0];

        for (int i = 0; i <= len - k; i++) { 
            int max = nums[i];
            for (int j = 1; j < k; j++) { 
                max = Math.max(nums[i + j], max);
            }
            res.add(max);
        }
        int[] resArray = new int[res.size()]; 
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    /**
    nums , n - 0||null 
    k>n 
    
    DS 
    Move the Window, Find Max
    When we move the window, we need to make sure the all element are in that window we need to discard the other 
    Queue or Stack : Working on Index or Value ? Big Question I Forget
    */

    public int[] dequeApproach(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1]; // You can use arrayList -> Convert to Array.
        if (nums == null || n == 0 || k > n) return new int[0];
        int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // Remove idx Out of Range
            if (!q.isEmpty() && q.peekFirst() == i - k) {
                q.pollFirst();
            }
            // Remove Smaller Element
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offerLast(i); // Adding Index to Queue

            // Addiing result to Ans
            if (i >= k - 1) {
                res[idx++] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}