/**
Look at the input, 
There are already in token you don't need to further split it.

Array Made of String.
While Pushing, We need to take care of Integer Data Type parseIn
Get aware of switch as well.
*/

class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if(tokens==null||n==0){
            return -1;
        }
        Deque<Integer> st = new ArrayDeque<>();
        for(String token : tokens){
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int x = st.pop();
                int y = st.pop();
                switch(token){
                    case "+":st.push(y+x);break;
                    case "-":st.push(y-x);break;
                    case "*":st.push(y*x);break;
                    case "/":
                        if(x!=0){
                            st.push(y/x);
                        }
                        break;                        
                }
            }else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}