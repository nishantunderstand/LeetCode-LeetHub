// LeetCode : 2095
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        //return dummyNodeDeleteMiddle(head);
        //return striverdeleteMiddle(head);
        return deleteMiddleThreeVariable(head);
    }

        public ListNode dummyNodeDeleteMiddle(ListNode head) {
        if(head==null || head.next == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = head;
        ListNode slow = dummy;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;            
        }
        slow.next = slow.next.next;    
        return dummy.next;
    }
    
    public ListNode striverdeleteMiddle(ListNode head) {
        if(head==null || head.next == null) return null;
                
        ListNode fast = head;
        ListNode slow = head;
        // Skipping 1 Slow 
        fast = fast.next.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;            
        }
        slow.next = slow.next.next;    
        return head;
    }

    public ListNode deleteMiddleThreeVariable(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;

        }
        prev.next = slow.next;
        return head;
    }
}