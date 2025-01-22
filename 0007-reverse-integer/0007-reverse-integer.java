// June 11,24 | T-O(n)
class Solution {
    public int reverse(int x) {

        // Negative Case-1
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }

        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        // Handle 32 Bit Integer Range, 1000007 => Reverse is invalid
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        // Negative Case-2
        if (flag) {
            rev = -rev;
        }
        return (int) rev;
    }
}