class Solution {
    public boolean isAnagram(String s, String t) {
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