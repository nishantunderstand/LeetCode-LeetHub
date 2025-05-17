// Leetcode : 19
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return twoPassSol(head,n);
        // return SinglePassTwoPointerSol(head,n);
    }

    // Saturday, May 17, 2025 8:46:51 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private ListNode twoPassSol(ListNode head, int k){
        if(k==0) return head;
        
        // Find Length
        ListNode temp = head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }

        if(k>=len) return head.next;

        temp = head;
        int range = len-k-1;  //<--
        for(int i=0;i<range;i++){
            temp = temp.next;
        }

        if(temp.next!=null){  //<--
            temp.next = temp.next.next;
        }
        
        return head;
    }
}