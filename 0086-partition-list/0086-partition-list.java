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
// LeetCode : 86
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessdummy = new ListNode(-1);
        ListNode moredummy = new ListNode(-1);
        
        ListNode lesstail = lessdummy;
        ListNode moretail = moredummy;

        ListNode curr = head;

        while(curr!=null){ // curr.next!=null ??
            if(curr.val < x){
                lesstail.next = curr;
                lesstail = lesstail.next;
            }else{
                moretail.next = curr;
                moretail = moretail.next;
            }
            curr = curr.next;
        }
        moretail.next = null; //???
        lesstail.next = moredummy.next;
        return lessdummy.next;
    }
}