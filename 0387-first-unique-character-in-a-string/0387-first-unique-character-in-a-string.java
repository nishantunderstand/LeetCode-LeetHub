// Leetcode : 387
class Solution {
    public int firstUniqChar(String s) {
        return linkedhashMapApproach(s);
        //return frequencyArrayApproach(s);
        //return hashMapApproach(s); // WRONG CODE? WHY ?
    }

    // WRONG CODE
    public int hashMapApproach(String s){
        HashMap<Character,Integer> hm = new HashMap<>();  //<--
        int len = s.length();
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            hm.put(curr,hm.getOrDefault(curr,0)+1);
            if(hm.get(curr)==1) return i;
        }        
        return -1;
    }


    // Saturday, February 8, 2025 6:01:15 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public int linkedhashMapApproach(String s){
        LinkedHashMap<Character,Integer> hm = new LinkedHashMap<>();  //<--
        int len = s.length();
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            hm.put(curr,hm.getOrDefault(curr,0)+1);
        }

        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            if(hm.get(curr)==1) return i;
        }
        
        return -1;
    }
    // Saturday, May 17, 2025 5:53:24 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public int frequencyArrayApproach(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
            
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}