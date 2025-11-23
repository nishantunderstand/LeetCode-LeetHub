// Leetcode : 20
// )( - Invalid 
class Solution {
    public boolean isValid(String s) {
        //return stackApproach(s);
        // return bruteForce(s);
        return hashingAndStack(s);
    }

    // Thursday, February 6, 2025 4:11:52 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public boolean hashingAndStack(String s) {
        int len = s.length();
        if(s==null || len==0 || len%2==1) return false;  //<--
        
        HashMap<Character,Character> hm = new HashMap<>();
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');

        ArrayDeque<Character> st = new ArrayDeque<>();
        // ()
        // {)
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            if(hm.containsKey(curr)){
                if(st.isEmpty() || st.peek()!=hm.get(curr)){  //<--
                    return false;
                }
                st.pop();
            }else{
                st.push(curr);
            }            
        }
        return st.isEmpty();
    }

    // Tuesday, December 17, 2024 8:56:49 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public boolean stackApproach(String s) {
        int n = s.length();
        if (s == null || n <= 0) return true; // Empty String is Valid 
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                st.push(curr);
            } else{
                if(st.isEmpty()) return false;  //<--
                char top = st.pop();
                if( (curr==')' && top!='(') ||
                    (curr=='}' && top!='{') ||
                    (curr==']' && top!='['))
                return false;
            }
        }
        // return st.isEmpty() ? true : false;
        return st.isEmpty(); // Better Version
    }


    /**
     * Friday, November 15, 2024 12:17:50 PM
     * T.C - O(n^2) | S.C - O(1)
     */
    public boolean bruteForce(String s) {
        if (s.length() <= 0)
            return false;
        boolean changed = true;
        while (changed) {
            int lengthBefore = s.length();
            s = s.replace("()", "") // O(n)
                    .replace("{}", "")
                    .replace("[]", "");

            int lengthAfter = s.length();
            if (lengthBefore == lengthAfter) {
                changed = false;
            }
        }
        return s.isEmpty();
    }
}