// Leetcode : 2351
class Solution {
    public char repeatedCharacter(String s) {
        //return freqArrayApproach(s);   
        //return hashMapApproach(s);
        //return linkedhashMapApproach(s); 
        return hashSetApproach(s);
    }
    // Sunday, November 23, 2025 12:50:59 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private char hashSetApproach(String s){
        Set<Character> seen = new HashSet<>();
        for(char ch : s.toCharArray()){
            if(seen.contains(ch)) return ch;
            seen.add(ch);
        }
        return '\0';
    }
    
    // Building Full Map then return Wrong Approach
    public char linkedhashMapApproach(String s){
        LinkedHashMap<Character,Integer> hm = new LinkedHashMap<>();  //<--
        int len = s.length();
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            hm.put(curr,hm.getOrDefault(curr,0)+1);
        }

        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            if(hm.get(curr)==2) return curr;
        }
        
        return '\0';
    }


    // Saturday, May 17, 2025 5:36:20 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
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
    // Time Complexity:O(n) | Space Complexity:O(1)
    public char freqArrayApproach(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';  //<--
            freq[idx]++;
            if(freq[idx]==2) return s.charAt(i);  //<--
        }
        return '\0';  //<--       
    }
}

// 387 – First Unique Character Vs 2351 – First Repeated Character