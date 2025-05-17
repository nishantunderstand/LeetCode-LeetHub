// Leetcode : 2351
class Solution {
    public char repeatedCharacter(String s) {
        //return freqArrayApproach(s);   
        return hashMapApproach(s);
    }

    private char hashMapApproach(String s){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            if(hm.get(ch)==2) return ch;
        }        
        return '\0';
    }

    // Saturday, May 17, 2025 5:36:20 PM
    // Time Complexity:O(n) | Space Complexity:O(1h)
    public char freqArrayApproach(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            freq[idx]++;
            if(freq[idx]==2) return s.charAt(i);  //<--
        }
        return '\0';  //<--       
    }
}