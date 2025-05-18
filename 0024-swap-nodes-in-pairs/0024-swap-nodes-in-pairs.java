// Leetcode : 24
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
class Solution {
    public ListNode swapPairs(ListNode head) {
        return swapValuesOnly(head);
    }

    private ListNode swapValuesOnly(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while(curr.next!=null && curr.next.next!=null){
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            // Swap Pointers
            first.next = second.next;
            second.next = first;
            curr.next = second;
            
            curr = first;  //<--    
        }
        return dummy.next;

    }
}