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
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return false; // No LL
        if(head.next==null) return true; // Single LL
        
        // Find Middle
        ListNode mid = findMiddle(head);
        ListNode reverseNode = reverse(mid);


        boolean isPalin = isEqual(head,reverseNode);

        // Restore the Node (Is Optinal)
        reverse(reverseNode); //<--
        
        return isPalin;
    }

    public boolean isEqual(ListNode head1,ListNode head2){
        while(head1!=null && head2!=null){ //<--
            if(head1.val!=head2.val) return false;
            head1=head1.next;
            head2=head2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){ //<--
            ListNode newNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNode;
        }
        return prev;
    }

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