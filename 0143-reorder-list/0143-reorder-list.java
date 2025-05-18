// Leetcode : 143
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
    // Sunday, May 18, 2025 5:20:29 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode mid = findMiddle(head);        
        ListNode second = reverse(mid.next);
        mid.next = null;
        ListNode first = head;
        merge2LL(first,second);
    }
    private void merge2LL(ListNode first, ListNode second){                
        while(first!=null && second!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    private ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Why it is giving wrong result ?
    private ListNode findMiddle1(ListNode head){
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}