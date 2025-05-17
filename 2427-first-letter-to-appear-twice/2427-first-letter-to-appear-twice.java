// Leetcode : 2351
class Solution {
    public char repeatedCharacter(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            freq[idx]++;
            if(freq[idx]==2) return s.charAt(i);  //<--
        }
        return '\0';  //<--       
    }
}