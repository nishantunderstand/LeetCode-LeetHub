// LeetCode : 61
class Solution {
    // Saturday, June 27, 2026 5:40:28 PM
	// TC : O(n) | SC : O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null ||k==0) return head;

        int len = findLen(head);
        k = k % len; //<--
        if(k==0) return head; //<--

        ListNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = head; // Circular Now  //<--
        
        int stepToNewTail = len-k;
        ListNode newTail = head;
        for(int i=1;i<stepToNewTail;i++){
            newTail = newTail.next;
        }        
        
        ListNode newHead = newTail.next; //  New Head
        newTail.next = null; // Break the Circle
        
        return newHead;

    }
    // Saturday, June 27, 2026 5:40:28 PM
	// TC : O(n) | SC : O(1)
    private int findLen(ListNode head){
        int len = 0;
        ListNode curr = head;
        while(curr!=null){
            len++;
            curr = curr.next;
        }
        return len;
    }
}