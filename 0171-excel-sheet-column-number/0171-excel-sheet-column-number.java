class Solution {
    public int titleToNumber(String columnTitle) {
        return bruteForceApproach(columnTitle);
    }
    public int bruteForceApproach(String columnTitle){
        if(columnTitle==null && columnTitle.length()<=0){
            return 0;
        }
        int ans=0;
        for(int i=0;i<columnTitle.length();i++){
            char ch = columnTitle.charAt(i);
            int curr = (ch-'A')+1;
            ans = ans*26 + curr;
        }
        return ans;
    }
}