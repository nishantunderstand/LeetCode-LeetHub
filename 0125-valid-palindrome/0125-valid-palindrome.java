/**
 * Remove Spaces, , Other by Regex
 * Convert to lowercase
 * Use String
 * Later Use StringBuilder
Learn Regex
Here we are comparing Character
 */

class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}