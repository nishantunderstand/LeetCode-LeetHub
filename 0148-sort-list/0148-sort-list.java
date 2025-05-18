// Leetcode : 148
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
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
    public ListNode merge2LL(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if(left!=null) curr.next=left;
        if(right!=null) curr.next=right;

        return dummy.next;
    }

    // 1 → 2 → 3 → 4
    // 1 → 2 → 3 → 4 → 5
    // Time Complexity:O(n) | Space Complexity:O(1)
    public ListNode findMiddle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) { //<--            
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode prev = null;  //<--
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null ) { 
            prev = slow;  //<--
            slow = slow.next;
            fast = fast.next.next;
            
        }
        return prev;        
    }

    
}