// Leetcode : 560
class Solution {
    public int subarraySum(int[] nums, int k) {
        //return bruteForceApproach(nums,k);
        //return slidingWindowCaterpillarMethod(nums, k); // FAILS For K==0
        //return prefixhashMapApproach(nums, k);
        return prefixhashMapApproachMOD(nums,k);
        //return prefixHashSetApproach(nums,k); // FAILED Question Need cnt 
    }

    // WORK:No, Check Existence
    // Count is Required
    // Will Not Work 
    private int prefixHashSetApproach(int[] nums, int k){
        HashSet<Integer> hs = new HashSet<>();
        hs.add(0);
        int cnt=0,windowSum=0;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum += nums[windowEnd];
            if(hs.contains(windowSum-k)) cnt++;
            hs.add(windowSum);
        }
        return cnt;
    }

    // T.C - O(n)| S.C - O(n)
    public int prefixhashMapApproachMOD(int[] nums, int k) {
        int n = nums.length;
        if (n <= 0)
            return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); //<--
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

    // T.C - O(n)| S.C - O(n)
    public int prefixhashMapApproach(int[] nums, int k) {
        int n = nums.length;
        if (n <= 0)
            return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int csum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            csum += nums[i];
            if (csum == k)
                cnt++;
            if (hm.containsKey(csum - k)) {
                cnt += hm.get(csum - k);
            }
            hm.put(csum, hm.getOrDefault(csum, 0) + 1);
        }
        return cnt;
    }

    // Sunday, June 9, 2024 2:17:34 PM
    // Time Complexity: O(n) | Space Complexity: O(1)    
    // Cannot handle [1] k=0 , CODE FAILS
    // Works For Positive Array ONLY
    public int slidingWindowCaterpillarMethod(int[] nums, int k) {
        int count = 0;
        int windowSum = 0;
        int start = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            windowSum += nums[i];

            while (windowSum > k) {
                windowSum -= nums[start];
                start++;
            }

            if (windowSum == k) {
                count++;
            }
        }
        return count;
    }

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
}