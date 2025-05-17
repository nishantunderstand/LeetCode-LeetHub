// Leetcode : 387
class Solution {
    public int firstUniqChar(String s) {
        return linkedhashMapApproach(s);
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
}