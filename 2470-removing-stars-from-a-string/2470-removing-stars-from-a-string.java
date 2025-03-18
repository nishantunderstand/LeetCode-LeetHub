//LeetCode 2390
class Solution {
    public String removeStars(String s) {
        //return forwardApproach(s);
        //return backwardApproachWRONG(s);
        return removeStarsNew(s);
    }

    // WILL LEAD TO INCORRECT RESULT 
    public String backwardApproachWRONG(String s) {
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

    // Time Complexity:O(n) | Space Complexity:O(n)
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

    // Tuesday, March 18, 2025 6:42:39 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public String removeStarsNew(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr =='*' && !st.isEmpty()){                
                st.pop();
            }else{
                st.push(curr);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
    /**
    leet**c******
    st => lec
    What if we have more number of ***
    erase*****
    How this is Handled ??
    */
}