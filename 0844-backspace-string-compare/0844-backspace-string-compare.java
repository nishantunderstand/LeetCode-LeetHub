// LeetCode : 844
// Sunday, October 11, 2026 1:02:15 PM    
// TC : O(n+m) | SC : O(n+m)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='#'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }

        // ------------------------
        Stack<Character> st2 = new Stack<>();
        
        for(char ch : t.toCharArray()){
            if(ch=='#'){
                if(!st2.isEmpty()){
                    st2.pop();
                }                
            }else{
                st2.push(ch);
            }
        }

        // ---------------------------

        if(st.size() != st2.size()) return false;

        while(!st.isEmpty()){
            if(st.pop() != st2.pop()) return false;
        }
        return true;
    }
}

