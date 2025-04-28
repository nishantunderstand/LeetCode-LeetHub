/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

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

        ListNode odd = oddDummy;
        ListNode even = evenDummy;

        ListNode curr = head;
        int idx = 1;  //<--

        while (curr != null) {
            if (idx % 2 == 1) {
                odd.next = curr;  //<--
                odd = odd.next;
            } else {
                even.next = curr;
                even = even.next;
            }
            idx++;
            curr = curr.next;
        }

        even.next = null;
        odd.next = evenDummy.next;
        return oddDummy.next;
    }
}