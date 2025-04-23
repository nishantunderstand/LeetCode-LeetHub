// Leetcode : 168
class Solution {
    public String convertToTitle(int columnNumber) {
        return bruteForceConvertToTitle(columnNumber);
    }

    // Friday, December 13, 2024 7:51:42 PM
    // T.C - O(logn26) | S.C - O(1)
    public String bruteForceConvertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char ch = (char) ('A' + (columnNumber % 26));
            res.append(ch);
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}