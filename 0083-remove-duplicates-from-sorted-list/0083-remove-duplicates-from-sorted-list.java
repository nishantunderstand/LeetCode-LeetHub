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
// Leetcode : 83
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //return sortedCase(head);
        //return unsortedCase(head);
        //return unsortedCaseDummy(head);
        return hashSetApproach(head);
    }

    // Friday, May 16, 2025 1:25:33 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    private ListNode hashSetApproach(ListNode head){
        if (head == null) return null;  //<--
        HashSet<Integer> seen = new HashSet<>();
        ListNode curr = head;
        seen.add(curr.val);

        while(curr.next!=null){
            if(seen.contains(curr.next.val)){
                curr.next = curr.next.next;
            }else{
                seen.add(curr.next.val); //<--
                curr = curr.next;
            }            
        }
        return head;
    }

    // Reliable and Safe
    // Friday, May 16, 2025 1:25:33 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public ListNode unsortedCaseDummy(ListNode head) {
        HashSet<Integer> seen = new HashSet<>();
        ListNode dummy = new ListNode(0, head); // Dummy before head
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            if (seen.add(curr.val)) { // First time seeing value
                prev = curr;
            } else {
                prev.next = curr.next; // Skip duplicate
            }
            curr = curr.next;
        }
        return dummy.next;
    }        


    // Friday, May 16, 2025 1:25:33 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
     private ListNode unsortedCase(ListNode head) {
        if (head == null) return null;

        HashSet<Integer> seen = new HashSet<>();
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (seen.contains(curr.val)) {
                prev.next = curr.next; // Remove curr
            } else {
                seen.add(curr.val);
                prev = curr; // Move prev to curr
            }
            curr = curr.next; // Move curr always
        }

        return head;
    }

    // Saturday, April 26, 2025 8:36:11 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    private ListNode sortedCase(ListNode head){
        if(head==null || head.next==null) return head;        
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.val == curr.next.val){
                // Skip Duplicate
                curr.next = curr.next.next; 
            }else{
                // Move to Next Node
                curr = curr.next; 
            }
        }
        // return curr; <-- WRONG
        return head;        
    }
}