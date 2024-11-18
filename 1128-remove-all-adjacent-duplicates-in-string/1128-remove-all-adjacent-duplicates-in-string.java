/**
Monday, November 18, 2024 12:23:54 PM
T.C - O(n^2/nlogn/n/√n/logn/1) 
S.C - O(n/1/HeightOfTree)
Verify it, Correct it. Explain it as well.

st.peek()==ch && !st.isEmpty() WRONG ORDER
*/



class Solution {
    public String removeDuplicates(String s) {
        if(s.length()<=0) return "";
        //return stackApproach(s);
        //return stackApproach2(s);
        return stackApproach3Better(s);
    }


    // Monday, November 18, 2024 12:26:34 PM
    // T.C - O(n+n+n)=O(n) | S.C - O(n+n)
    public String stackApproach3Better(String s){
        ArrayDeque<Character> st = new ArrayDeque<>(); //O(n)
        for(int i=s.length()-1;i>=0;i--){ // O(n)
            Character ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch ){
                st.pop();
            }else{
                st.push(ch);
            }                                    
        }
        StringBuilder sb = new StringBuilder(); // O(n)
        while(!st.isEmpty()){ // O(n)
             sb.append(st.pop());
        }
        return sb.toString(); // O(n)        
    }
    
    // Monday, November 18, 2024 12:26:34 PM
    // T.C - O(n+n+n^2)=O(n^2) | S.C - O(n+n)
    public String stackApproach2(String s){
        ArrayDeque<Character> st = new ArrayDeque<>(); //O(n)
        for(int i=0;i<s.length();i++){ // O(n)
            Character ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch ){
                st.pop();
            }else{
                st.push(ch);
            }                                    
        }
        StringBuilder sb = new StringBuilder(); // O(n)
        while(!st.isEmpty()){ // O(n^2) // This Approach is not Correct or Recommended
            sb.insert(0,st.pop());
        }
        return sb.toString(); // O(n)        
    }


    // Monday, November 18, 2024 12:26:34 PM
    // T.C - O(n+n+n) | S.C - O(n+n)
    public String stackApproach(String s){
        ArrayDeque<Character> st = new ArrayDeque<>(); //O(n)
        for(int i=0;i<s.length();i++){ // O(n)
            Character ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch ){
                st.pop();
            }else{
                st.push(ch);
            }
            
        }
        StringBuilder sb = new StringBuilder(); // O(n)
        while(!st.isEmpty()){ // O(n)
            sb.append(st.pop());
        }
        return sb.reverse().toString(); // O(n) + O(n)
        // TC From StringBuilder to String 
    }
}