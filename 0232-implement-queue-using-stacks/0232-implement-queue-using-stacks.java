class MyQueue {
    Stack<Integer> st;
    Stack<Integer> temp;

    public MyQueue() {
        st = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        st.push(x);
    }

    public int pop() { // LIFO -> FIFO
        if(st.isEmpty()){
            return 0;
        }
        // Move Data From st -> temp 
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        int val = temp.pop();
        // Move Data From temp --> st 
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        // return 
        return val;    
    }

    public int peek() {
        if(st.isEmpty()){
            return 0;
        }
        
        // Move Data From st -> temp 
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        int val = temp.peek();
        // Move Data From temp --> st 
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        // return 
        return val;  
        
    }

    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */