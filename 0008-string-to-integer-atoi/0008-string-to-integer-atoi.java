class Solution {
    public int myAtoi(String s) {
        if(s == null) return 0;
        s = s.trim();
        if(s.length() == 0) return 0;
        int sign = 1;
        int i = 0;  
        long ans = 0;
        if(s.charAt(0) == '-') {
            sign = -1;
            i++; //<--
        }else if(s.charAt(0) == '+') {
            i++; //<--
        }
        
        
        while(i < s.length()) {
            if(s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) {
                break;
            }

            ans = ans * 10 + (s.charAt(i) - '0');


            if(sign == -1 && (-1 * ans) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if(sign == 1 && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            i++;
        }

        return (int)(sign * ans);
    }
}

// Sunday, June 14, 2026 8:25:52 PM
// TC : O(n) | SC : O(1)
// LeetCode : 8
// Possible Edge Case : "+1"

