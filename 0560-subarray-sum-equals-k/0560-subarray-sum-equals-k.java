/**
- Sum Checking should be done inside the Class.
- Regarding SubArray, It need to be continous subArray
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        return bruteForceApproach(nums, k);
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