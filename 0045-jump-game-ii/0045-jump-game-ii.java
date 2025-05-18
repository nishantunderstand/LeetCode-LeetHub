class Solution {
    public int jump(int[] nums) {
        return greedySolution(nums);
    }


    public int greedySolution(int[] A) {
        int n = A.length;

        if (n <= 1) return 0;
        if (A[0] == 0) return -1;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + A[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                if (currentEnd >= n - 1) break;
                if (currentEnd == i) return -1; // stuck
            }
        }

        return currentEnd >= n - 1 ? jumps : -1;
    }

}