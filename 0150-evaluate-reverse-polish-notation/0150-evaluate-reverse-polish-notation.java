// LeetCode : 150
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if(tokens==null||n==0){
            return -1;
        }
        Deque<Integer> st = new ArrayDeque<>();
        for(String token : tokens){
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int op2 = st.pop();
                int op1 = st.pop();
                switch(token){
                    case "+":st.push(op1+op2);break;
                    case "-":st.push(op1-op2);break;
                    case "*":st.push(op1*op2);break;
                    case "/":
                        if(op2!=0){
                            st.push(op1/op2);
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