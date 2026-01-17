// Leetcode : 148
class Solution {
    public ListNode sortList(ListNode head) {        
        return mergeLL(head);
    }

    // Thursday, March 20, 2025 5:55:02 PM
    // Time Complexity:O(nlogn) | Space Complexity:O(logn)
    public ListNode mergeLL(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMiddle(head);        
        ListNode head2 = mid.next;
        mid.next = null;

        ListNode left = mergeLL(head);
        ListNode right = mergeLL(head2);
        return merge2LL(left, right);
    }

    // Time Complexity:O(n) | Space Complexity:O(1)
    public ListNode merge2LL(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        curr.next = (head1!=null)?head1:head2;
        return dummy.next;
    }

    // 1 → 2 → 3 → 4
    // 1 → 2 → 3 → 4 → 5
    // Time Complexity:O(n) | Space Complexity:O(1)
    public ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;  //<--
        ListNode slow = head;
        while (fast != null && fast.next != null ) {            
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }    
}