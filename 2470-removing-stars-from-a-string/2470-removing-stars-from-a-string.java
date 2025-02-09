//LeetCode 2390

class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        if(s==null || len==0) return "";
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            if(curr!='*') st.push(curr);        
            else if(!st.isEmpty()) st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}