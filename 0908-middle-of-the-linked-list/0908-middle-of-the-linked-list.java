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
// LeetCode : 876
/** 
Even Or Odd Length
How to find 1st Or 2nd Middle
2nd Middle : Default fast=head, slow=head;
1st Middle : fast = head.next, slow = head;
*/
class Solution {
    public ListNode middleNode(ListNode head) {
        return fastAndSlow(head);
    }

    // Friday, March 21, 2025 6:02:29 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public ListNode fastAndSlow(ListNode head){
        if(head==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}