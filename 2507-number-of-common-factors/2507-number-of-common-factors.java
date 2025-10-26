// LeetCode : 2427
class Solution {
    public int commonFactors(int a, int b) {
        if(a==0 || b==0) return 0;
        //return optimizedApproach(a,b);
        return gcdApproach(a,b);
    }

    // Sunday, September 14, 2025 1:23:06 PM
    // Time Complexity:O(sqrt(gcd) | Space Complexity:O(1)
    public int gcdApproach(int a, int b) {
        int gcd = findGCD(a,b);
        int cnt=0;
        
        for(int i=1;i<=gcd/i;i++){  //<--
            if(gcd%i!=0) continue;
            if(i==gcd/i) cnt=cnt+1;
            else cnt=cnt+2;
        }
        return cnt;
    }
    // Time Complexity:O(log(min(a,b))) | Space Complexity:O(log(min(a,b)))
    private int findGCD(int a,int b){
        if(b==0) return a;
        return findGCD(b,a%b);
    }

    // Saturday, September 13, 2025 9:26:25 PM
    // Time Complexity:O(min(a,b)) | Space Complexity:O(1)
    public int optimizedApproach(int a, int b) {
        if(a==0 ||b ==0){
            return 0;
        }
        int maxDiv = Math.min(a,b);        
        int cnt = 0;
        for(int div=1;div<=maxDiv;div++){
            if(a%div==0 && b%div==0){
                cnt++;
            }
        }
        return cnt;
    }
}