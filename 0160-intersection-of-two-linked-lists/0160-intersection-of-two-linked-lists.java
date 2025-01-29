/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return hashSetApproach(headA,headB);
    }

    // Wednesday, January 29, 2025 6:37:56 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public ListNode hashSetApproach(ListNode head1, ListNode head2) {
        if(head1==null) return null;
        if(head2==null) return null;
        if(head1==null && head2==null) return null;

        HashSet<ListNode> seen = new HashSet<>();
        while(head1!=null){
            seen.add(head1);
            head1=head1.next;
        }
        while(head2!=null){
            if(seen.contains(head2)){
                return head2;
            }
            head2=head2.next;
        }
        return null;
    }
}