// LeetCode : 92
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //return enggDiestApproach(head, left, right);
        return mikApproach(head, left, right);
    }

    // Thursday, November 5, 2026 11:57:44 PM    
    // TC : O(n) | SC : O(1)
    public ListNode mikApproach(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;
        
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        ListNode curr = prev.next;
        
        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        
        return dummyNode.next;
    }

    public ListNode enggDiestApproach(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        int i = 1;
        while (curr != null && i != left) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode pointerToStart = prev;
        ListNode start = curr;

        prev = null;

        while (curr != null && i != right + 1) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            i++;
        }

        start.next = curr;
        if (pointerToStart != null) {
            pointerToStart.next = prev;
        } else {
            return prev;
        }
        return head;
    }
}