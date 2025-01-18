public class Solution {
    public int consecutiveNumbersSum(int n) {
        // return twoPointerApproach(n);
        return normalApproach(n);
    }

    // Normal approach with iteration
    public int normalApproach(int n) {
        int count = 0;
        int i = 1;
        while (n > 0) {
            n = n - i;
            if (n % i == 0)
                count++;
            i++;
        }
        return count;
    }

    // TLE: Two-pointer approach
    public int twoPointerApproach(int n) {
        int count = 0; // Initialize count of valid sequences
        int start = 1, end = 1, sum = 0; // Two pointers and the sum

        while (start <= n) { // Ensure the sequence starts with a positive integer
            if (sum < n) {
                sum += end; // Expand the sequence
                end++;
            } else if (sum > n) {
                sum -= start; // Shrink the sequence
                start++;
            } else {
                count++; // Found a valid sequence
                sum -= start; // Shrink to find other sequences
                start++;
            }
        }

        return count; // Do not add 1 here; `n` itself is already included in the logic
    }
}
