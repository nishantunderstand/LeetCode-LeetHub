//LeetCode 2390

class Solution {
    public String removeStars(String s) {
        return forwardApproach(s);
        // return backwardApproach(s);
    }

    // WILL LEAD TO INCORRECT RESULT 
    public String backwardApproach(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        if(s==null || len==0) return "";
        
        for(int i=len-1;i>=0;i--){
            char curr = s.charAt(i);
            if(curr!='*') st.push(curr);  //<--     
            else if(!st.isEmpty()) st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public String forwardApproach(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        if(s==null || len==0) return "";
        for(int i=0;i<len;i++){
            char curr = s.charAt(i);
            if(curr!='*') st.push(curr);  //<--     
            else if(!st.isEmpty()) st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}