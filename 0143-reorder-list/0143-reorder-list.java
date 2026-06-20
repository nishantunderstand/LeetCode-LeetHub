class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode mid = findMiddleNode(head);
        ListNode secondHalf = mid.next;
        mid.next = null;    

        secondHalf = reverseLL(secondHalf);
        ListNode firstHalf = head;
        
        while(secondHalf!=null){
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    private static ListNode findMiddleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;            
        }
        return slow;
    }
    
    private static ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null;
        while(curr!=null){
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}