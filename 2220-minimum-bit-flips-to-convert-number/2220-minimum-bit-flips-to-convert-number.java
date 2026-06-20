class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int cnt = 0;
        for(int i=0;i<32;i++){            
            if((ans & (1<<i))!=0){
                cnt++;
            }
        }
        return cnt;
    }
}
// Wednesday, June 10, 2026 8:52:53 PM
// TC : O(32) | SC : O(1)
// LeetCode : 2220