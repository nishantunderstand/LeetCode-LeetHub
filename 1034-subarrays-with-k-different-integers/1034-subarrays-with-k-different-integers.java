class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int startIdx = 0;
        int cnt = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // Same as Calculating WindowSum
            int num = nums[i];
            count.put(num, count.getOrDefault(num, 0) + 1);

            while (count.size() > k) {
                // Same as Decreasing WindowSum
                int startIdxNum = nums[startIdx];
                count.put(startIdxNum, count.get(startIdxNum) - 1);
                
                // If it reach Zero, Then Discard It
                if (count.get(startIdxNum) == 0) {
                    count.remove(startIdxNum);
                }
                startIdx++;
            }
            cnt += i - startIdx + 1;
        }
        return cnt;
    }
}