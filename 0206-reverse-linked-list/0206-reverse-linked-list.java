// LeetCode:206
class Solution {
    public ListNode reverseList(ListNode head) {
        //return reverseApproach(head);
        return stackApproachTUF(head);
    }

    // Tuesday, March 18, 2025 8:03:16 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public ListNode stackApproachTUF(ListNode head) {
        if(head==null) return null;
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;        
        while(curr!=null){
            st.push(curr);
            curr = curr.next;
        }        
        ListNode newHead = st.pop();  //<--
        curr = newHead;
        while(!st.isEmpty()){
            curr.next = st.pop();
            curr = curr.next;
        }
        curr.next=null;  //<--
        return newHead;
    }

    // Tuesday, March 18, 2025 8:03:45 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public ListNode reverseApproach(ListNode head) {
        if(head==null){
            return null;
        }
    
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;         
            curr.next = prev;
            prev = curr;
            curr = temp;            
        }
        return prev;
    }
}