class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;                         
    }
}
// Monday, May 11, 2026 8:40:26 PM
// LeetCode : 371