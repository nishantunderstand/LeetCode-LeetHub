// LeetCode : 19
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return lengthApproach(head,n);
        //return gapApproach(head,n);
    }

    private ListNode gapApproach(ListNode head, int n) {
        if(head==null) return null;        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;        
        // Create a Gap if n nodes 
        for(int i=0;i<n;i++){
            fast = fast.next;        
        }
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;            
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    private ListNode lengthApproach(ListNode head, int n) {
        int len = findLL(head);    
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        for(int i=0;i<len-n;i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
    private int findLL(ListNode head){
        int cnt=0;
        while(head!=null){
            cnt++;
            head = head.next;        
        }
        return cnt;
    }
}