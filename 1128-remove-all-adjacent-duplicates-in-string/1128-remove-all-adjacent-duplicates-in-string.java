/**
Monday, November 18, 2024 12:23:54 PM
T.C - O(n^2/nlogn/n/√n/logn/1) 
S.C - O(n/1/HeightOfTree)
Verify it, Correct it. Explain it as well.

st.peek()==ch && !st.isEmpty() WRONG ORDER
*/



class Solution {
    public String removeDuplicates(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
  
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch ){
                st.pop();
            }else{
                st.push(ch);
            }
            
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}