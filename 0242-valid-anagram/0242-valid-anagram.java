// Leetcode : 242
class Solution {
    public boolean isAnagram(String s, String t) {
       //return bruteForceApproach(s,t);
       //return freqArrayApproach(s,t);
       return hashMapApproach(s,t);
    }
    // Thursday, February 5, 2026 11:46:24 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private boolean hashMapApproach(String str, String tar){        
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char ch : str.toCharArray()){
            fmap.put(ch, fmap.getOrDefault(ch,0)+1);
        }        
        for(char ch : tar.toCharArray()){
            if(!fmap.containsKey(ch)){
                return false;
            }
            fmap.put(ch,fmap.get(ch)-1);
            if(fmap.get(ch)==0){
                fmap.remove(ch);
            }
        }
        return fmap.isEmpty();           
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

    // Wednesday, August 17 2024
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