// LeetCode : 392
// Tuesday, August 11, 2026 12:20:52 AM
// TC : O(n) | SC : O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i <s.length() && j<t.length()){
            if(s.charAt(i)!=t.charAt(j)){
                j++;
            }else if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
        }
        return (i==s.length());
    }
}