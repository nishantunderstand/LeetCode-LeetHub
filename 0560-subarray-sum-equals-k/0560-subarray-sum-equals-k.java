class Solution {
    public int subarraySum(int[] nums, int k) {
        return bruteForceApproach(nums,k);
        //return hashMapApproach(nums,k);
        //return slidingWindowCaterpillarMethod(nums,k);
    }

    /**
     * - Sum Checking should be done inside the Class.
     * - Regarding SubArray, It need to be continous subArray
     */
    // Wednesday, December 11, 2024 9:46:20 PM
    // T.C - O(n^2) | S.C - O(1)
    public int bruteForceApproach(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int csum = 0;
            for (int j = i; j < nums.length; j++) {
                csum += nums[j];
                if (csum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * Thursday, October 24, 2024 10:22:12 PM
     * 
     * Thinking of HashSet NO
     * Think of HashMap - We need to return the Frequency of Occurence.
     * 
     * [-1,-1,1] , K=0
     * 
     * n<=0 || k<=0 return 0; // This is WRONG, Applying Constraint on k is WRONG
     * 
     * T.C - O(n)| * S.C - O(n)
     */

    public int hashMapApproach(int[] nums, int k) {
        int n = nums.length;
        if (n <= 0)
            return 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int csum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            csum += nums[i];
            if (hm.containsKey(csum - k)) {
                cnt += hm.get(csum - k);
            }
            hm.put(csum, hm.getOrDefault(csum, 0) + 1);
        }
        return cnt;
    }

    /**
     * Sunday, June 9, 2024 2:17:34 PM
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Please Update Here, TimeComplexity and SpaceComplexity of the Code. Explain
     * in Detail.
     */

    public int slidingWindowCaterpillarMethod(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}