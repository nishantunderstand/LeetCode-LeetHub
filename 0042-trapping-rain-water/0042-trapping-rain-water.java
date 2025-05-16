// Leetcode : 42
class Solution {
    public int trap(int[] height) {
        //return bruteForce(height); // TLE
        return prefixApproach(height);
        //return twoPointerApproach(height);
    }

    private int twoPointerApproach(int[] height){
       return 0;
    }

    // Friday, May 16, 2025 12:43:52 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int prefixApproach(int[] height) {
        int totalWater = 0;
        int n = height.length;
        // PrefixMaxOfLeft
        int[] maxLeft = new int[n];
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        // PrefixMaxOnRight
        int[] maxRight = new int[n];
        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (water > 0) {
                totalWater += water;
            }
        }
        return totalWater;
    }

    // Friday, May 16, 2025 12:43:56 PM
    // Time Complexity:O(n^2) | Space Complexity:O(1)
    public int bruteForce(int[] height) {
        int totalWater = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            int maxL = 0;
            int maxR = 0;
            for (int j = 0; j <= i; j++) {
                maxL = Math.max(maxL, height[j]);
            }
            for (int j = i; j < n; j++) {
                maxR = Math.max(maxR, height[j]);
            }
            int water = Math.min(maxL, maxR) - height[i];  //<--
            if (water > 0) {
                totalWater += water;
            }
        }
        return totalWater;
    }

}