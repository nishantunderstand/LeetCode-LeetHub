class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            int elem = asteroids[i];            
            if(elem>0){
                st.push(elem);
            }else{
                // Top Element is Postive and Bigger, Pop Till it reached Zero
                while(!st.isEmpty() && st.peek()>0 && Math.abs(elem)>st.peek()){
                    st.pop();
                }
                // If the stack is empty or the top is negative, push the current asteroid
                if(st.isEmpty() || st.peek()<0) st.push(elem);
                
                // Equality Condition
                if(st.peek() + elem ==0) st.pop();
            }
        }
        
        // Converting to Array 
        int[] res = new int[st.size()];
        int len = res.length-1;
        
        for(int i=len;i>=0;i--){
            res[i]=st.pop();
        }
        return res;
    }
}

/**
[-5,-5,-5]
How this is Handled ?
*/