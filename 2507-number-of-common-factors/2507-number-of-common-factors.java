// LeetCode : 2427
class Solution {
    public int commonFactors(int a, int b) {
        return optimizedApproach(a,b);
    }

    // Saturday, September 13, 2025 9:26:25 PM
    // Time Complexity:O(Min(a,b)) | Space Complexity:O(1)
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