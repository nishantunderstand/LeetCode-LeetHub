class Solution {
    public int maxDepth(String s) {
        int currDepth  = 0;
        int maxDepth = 0;  

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                currDepth++;
                maxDepth = Math.max(maxDepth,currDepth);
            }else if(ch==')'){
                currDepth--;
            }
        }
        return maxDepth;
    }
}
// Saturday, June 6, 2026 10:59:21 PM
// TC : O(n) | SC : O(1)
// LeetCode : 1614