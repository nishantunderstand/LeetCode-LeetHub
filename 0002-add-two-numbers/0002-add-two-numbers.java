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

// Wednesday, January 1, 2025 11:50:08 PM
// Time Complexity:O(max(size(l1),size(l2))) | Space Complexity:O(max(size(l1),size(l2)))
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy=new ListNode(0);
        ListNode curr = dummy;
        int dig =0;
        int carry=0;
        while(l1!=null || l2!=null||carry>0){
            dig = carry;
            if(l1!=null){
                dig+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                dig+=l2.val;
                l2=l2.next;
            }
            carry = dig/10;
            curr.next = new ListNode(dig%10);
            curr = curr.next;
        }
        return dummy.next;
    }
}