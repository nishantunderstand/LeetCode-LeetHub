class Solution {
    public boolean rotateString(String s, String goal) {
        // Length Mismtach One 
        if(s.length()!=goal.length()) return false;
        //return (s+s).contains(goal);
        return (goal+goal).contains(s);
    }
}
// Saturday, June 6, 2026 6:05:16 PM
// TC : O(n nlogn) | SC : O(1 n)
// LeetCode : 796