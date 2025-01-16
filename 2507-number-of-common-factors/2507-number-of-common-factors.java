class Solution {
    public int commonFactors(int a, int b) {
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