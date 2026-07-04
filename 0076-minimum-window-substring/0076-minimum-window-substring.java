// LeetCode : 76
class Solution {    
    public String minWindow(String s, String t) {        
        return slidingwinodowMIK(s,t);
    }
    // Saturday, July 4, 2026 7:36:55 PM
	// TC : O(n) | SC : O(n)
    private String slidingwinodowMIK(String s, String t) {
        if(s.length()<t.length()) return "";
        Map<Character,Integer> need = new HashMap<>();
        // Build It
        for(char ch : t.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        int left = 0;
        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        // Expand the Winodw 
        for(int right=0;right<s.length();right++){
            char rightChar = s.charAt(right);
            
            if(need.getOrDefault(rightChar,0)>0){
                required--;
            }
            // Character Contributes towards
            need.put(rightChar, need.getOrDefault(rightChar,0)-1);
                        
            while(required==0){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }
                // Remove Left Char From the winow 
                char leftChar = s.charAt(left);
                need.put(leftChar,need.get(leftChar)+1);
                // Window becomes invalid After removal

                if(need.get(leftChar)>0){
                    required++;
                } 
                left++;               
            }
        }
        return minLen == Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}