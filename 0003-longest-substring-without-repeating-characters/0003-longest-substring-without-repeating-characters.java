class Solution {
    public int lengthOfLongestSubstring(String s) {
        // SlidingWindow 
        HashSet<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int startIdx = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            while(charSet.contains(s.charAt(i))){
                charSet.remove(s.charAt(startIdx));
                startIdx++;
            }
            charSet.add(s.charAt(i));
            maxLength = Math.max(maxLength,i-startIdx+1);
        } 
        return maxLength;
    }
}