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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode prev=dummyNode;
        for(int i=1;i<left;i++){
            prev=prev.next;
        }
        ListNode curr = prev.next;
        for(int i=0;i<right-left;i++){
            ListNode temp = curr.next;
            curr.next=temp.next;
            temp.next=prev.next;
            prev.next=temp;
        }

        return dummyNode.next;
    }
}