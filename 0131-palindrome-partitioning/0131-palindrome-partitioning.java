// LeetCode : 131

// Friday, November 13, 2026 12:49:39 AM    
// TC : O(n* 2^n) | SC : O(1n2^nlogkh)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrackingFor(s, res, new ArrayList<>(), 0);
        return res;
    }

    // TC : O(n*2 * 2^n) | SC : O(n^2)
    private void backtrackingFor(String str, List<List<String>> res, List<String> curr, int idx) {
        // BaseCase 
        if (idx == str.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            String prefix = str.substring(idx, i + 1);

            if (isPalindrome(prefix)) { // Call When it is valid 
                curr.add(prefix);
                backtrackingFor(str, res, curr, i + 1);
                curr.remove(curr.size() - 1);
            }
        }

    }

    // TC : O(n) | SC : O(1)
    private boolean isPalindrome(String str) {
        int li = 0;
        int ri = str.length() - 1;
        while (li < ri) {
            char left = str.charAt(li);
            char right = str.charAt(ri);
            if (left != right)
                return false;
            li++;
            ri--;
        }
        return true;
    }
}