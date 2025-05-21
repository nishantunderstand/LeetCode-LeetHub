// Leetcode : 242
class Solution {
    public boolean isAnagram(String s, String t) {
       //return bruteForceApproach(s,t);
       return freqArrayApproach(s,t);
    }

    // Wednesday, May 21, 2025 9:48:29 PM
    // Time Complexity:O(n) | Space Complexity:O(26)
    private boolean freqArrayApproach(String s, String t) {
        if(s.length()!=t.length()) return false;

        int[] freqArr = new int[26];
        for(char ch : s.toCharArray()){
            freqArr[ch-'a']++;
        }
        for(char ch : t.toCharArray()){
            freqArr[ch-'a']--;
        }
        for(int i=0;i<freqArr.length;i++){
            if(freqArr[i]!=0) return false;
        }
        return true;
    }

    // Wednesday, May 21, 2025 9:48:29 PM
    // Time Complexity:O(n + nlogn) | Space Complexity:O(n)
    public boolean bruteForceApproach(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        
        return Arrays.equals(sarr,tarr);
    }
}


/**
String  - ToLowerCase, Remove SpecialCharacter 

Length Mismatch - False
Length same,
Sort then compare 
directly compare - This is wrong here we are comparing the value
abc, bac

If both have same lenght, If all the element of string s is present in string t, then we can say both are equal.
*/