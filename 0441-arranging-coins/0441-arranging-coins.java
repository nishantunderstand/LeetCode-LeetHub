// Leetcode : 441
class Solution {
    public int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        long potAns = 0;
        while(start<=end){
            long mid = start + (end-start)/2;  //<--
            long total = mid * (mid+1)/2;

            if(total==n){
                return (int) mid;
            }else if(total<n){
                potAns = mid;  //<--
                start = mid+1;
            }else{
                end = mid-1;
            }
        }        
        return (int)potAns;        
    }
}
