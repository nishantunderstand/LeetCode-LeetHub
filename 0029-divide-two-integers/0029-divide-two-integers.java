// LeetCode : 29
class Solution {
    public int divide(int dividend, int divisor) {
        return bitsStriverApproach(dividend,divisor);
    }

    // Saturday, July 4, 2026 12:58:42 AM
	// TC = O(log² N) | SC : O(1)
    public int bitsStriverApproach(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        boolean sign = true;

        if(dividend> 0  && divisor <0) sign = false;
        else if(dividend<0 && divisor >0)  sign = false;
        
        long n = Math.abs(1L* dividend); //<--
        long d = Math.abs(1L* divisor); //<--
        long quotient = 0;
        while(n>=d){
            int cnt = 0;
            while(n>= (d<<(cnt+1))){
                cnt +=1;
            }
            quotient += 1<<cnt;
            n -= (d<<cnt);
        }
        if(quotient == (1<<31) && sign) return Integer.MAX_VALUE;
        if(quotient == (1<<31) && !sign) return Integer.MIN_VALUE;
        return (int) (sign? quotient:-quotient); //<--
    }

    
}