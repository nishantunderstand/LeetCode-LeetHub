// LeetCode : 1796
class Solution {
    public int secondHighest(String s) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for(char ch : s.toCharArray()){
            if(ch >='0' && ch <='9'){
                int digit = ch-'0';  //<--
                if(digit>max){
                    smax = max;
                    max = digit;
                }else if(digit<max && digit>smax){
                    smax = digit;
                }
            }
        }
        return smax==Integer.MIN_VALUE?-1:smax;
    }
}