/**
Friday, November 15, 2024 12:17:50 PM
T.C - O(n^2)
S.C - O(1)
*/

class Solution {
    public boolean isValid(String s) {
        if(s.length()<=0) return false;
        boolean changed = true;
        while(changed){
            int lengthBefore = s.length();
            s = s.replace("()","") // O(n)
                .replace("{}","")
                .replace("[]","");

            int lengthAfter = s.length();
            if(lengthBefore == lengthAfter){
                changed = false;
            }
        }
        return s.isEmpty();
    }
}