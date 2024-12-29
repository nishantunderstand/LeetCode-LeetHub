/**
 * Can we Convert to 111 then count no of set bits ? Will this approach make
 * sense ?
 * Brute Force Approach O(n)
 */

class Solution {
    public int hammingWeight(int n) {
        //return stringApproach(n);
        //return keriningApproach(n);
        return iterateFromEnd(n);
    }

    // Sunday, December 29, 2024 12:37:58 PM
    // Time Complexity:O(32) | Space Complexity:O(1)
    public int iterateFromEnd(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                count++;
        }
        return count;
    }

    // Time Complexity:O(32) | Space Complexity:O(1)
    public int keriningApproach(int n) {
        int rbsm = (n & -n);
        int count = 0;
        while (n != 0) {
            n = n - rbsm;
            rbsm = n & -n;
            count++;
        }
        return count++;
    }
    // Time Complexity: \U0001d442 ( \U0001d458 + \U0001d45a ) O(k+m), where \U0001d458 k is the number of bits in the binary representation of n (up to 32 for integers) and \U0001d45a m is the length of the string (which is proportional to \U0001d458 k).
    // Time Complexity:O(k+m) | Space Complexity:O(k)
    public int stringApproach(int n) {
        StringBuffer str = new StringBuffer();
        while (n > 0) {
            int rem = n % 2;
            str.append(rem);
            n = n / 2;
        }
        // Can i declare it with -1 ? As we are counting it may lead to Incorrect No ?
        // While Adding, Start with 0
        // While Updating,Like maxVal or Updating, then You can use it ?
        int noOfones = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') { // 1 is Wrong '1'
                noOfones++;
            }
        }
        return noOfones;
    }
}