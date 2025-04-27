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
// Leetcode : 86
class Solution {
    public ListNode partition(ListNode head, int x) {
        return inPlaceApproach(head,x);
    }

    // Sunday, April 27, 2025 1:29:12 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private ListNode inPlaceApproach(ListNode head, int val){        
        ListNode lessThanDummy = new ListNode(0);  //<--
        ListNode moreThanDummy = new ListNode(0);
        ListNode lessThan = lessThanDummy;
        ListNode moreThan = moreThanDummy;
        
        ListNode curr = head; // Temp Node For Iterating
        while(curr!=null){
            if(curr.val<val){
                lessThan.next = curr;
                lessThan = lessThan.next;
            }
            else{
                moreThan.next = curr;
                moreThan = moreThan.next;
            }
            curr = curr.next;
        }
        
        // End moreThan
        moreThan.next = null;  //<--

        // Connect lessThan with moreThan
        lessThan.next = moreThanDummy.next;  //<--
        
        //lessThan.next = moreThan.next; moreThan.next IS SET NULL

        return lessThanDummy.next;  //<--        
    }
}