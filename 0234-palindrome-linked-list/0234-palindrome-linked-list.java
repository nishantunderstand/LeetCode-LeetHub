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

// LeetCode 234

// Tuesday, March 18, 2025 7:54:37 PM
// Time Complexity:O(n) | Space Complexity:O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return false; // No LL
        if(head.next==null) return true; // Single LL
        
        // Find Middle
        ListNode mid = findMiddle(head);

        ListNode reverseNode = reverse(mid);

        boolean isPalin = isEqual(head,reverseNode);

        // Restore the Node (Best Pratices)
        reverse(reverseNode); //<--
        
        return isPalin;
    }

    // Time Complexity:O(n) | Space Complexity:O(1)
    public boolean isEqual(ListNode head1,ListNode head2){
        // Should I Check for Length Mismatch ?
        while(head1!=null && head2!=null){ //<--
            if(head1.val!=head2.val) return false;
            head1=head1.next;
            head2=head2.next;
        }
        return true;
    }

    // Time Complexity:O(n) | Space Complexity:O(1)
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){ //<--
            ListNode temp = curr.next; //<--
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    // Time Complexity:O(n) | Space Complexity:O(1)
    public ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;            
            // if(fast==slow)break; // WRONG  // ONLY USED FOR CHECKING LOOP ONLY 
        }
        return slow;
    }
}