// Leetcode : 2816
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
    public ListNode doubleIt(ListNode head) {
        return revDoublerev(head);
    }
    // Sunday, May 18, 2025 11:04:42 AM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public ListNode revDoublerev(ListNode head) {
        head = reverse(head);  //<--
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = head;
        ListNode resultCurr = dummy;

        int carry = 0;
        while(curr!=null){

            int newVal = curr.val*2 + carry;
            resultCurr.next = new ListNode(newVal%10);
            carry = newVal/10;

            curr = curr.next;
            resultCurr = resultCurr.next;
        }

        // 999-> 1998
        if(carry>0){
            resultCurr.next = new ListNode(carry);  //<--
        }

        return reverse(dummy.next);
    }


    // Time Complexity:O(n) | Space Complexity:O(1)
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
}