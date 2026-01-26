// Leetcode : 328
class Solution {
    public ListNode oddEvenList(ListNode head) {
        return reOrderOddEvenList(head);
    }
    // Sunday, April 27, 2025 1:54:05 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public ListNode reOrderOddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);

        ListNode oddtail = oddDummy;
        ListNode eventail = evenDummy;

        ListNode curr = head;
        int idx = 1;  //<--

        while (curr != null) {
            if (idx % 2 == 1) {
                oddtail.next = curr;  //<--
                oddtail = oddtail.next;
            } else {
                eventail.next = curr;
                eventail = eventail.next;
            }
            idx++;
            curr = curr.next;
        }

        eventail.next = null;  //<--
        oddtail.next = evenDummy.next;  //<--
        return oddDummy.next;
    }
}