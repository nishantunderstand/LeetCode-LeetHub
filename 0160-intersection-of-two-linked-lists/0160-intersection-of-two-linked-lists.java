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
// LeetCode : 160
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //return hashSetApproach(headA,headB);
        return twoPointerApproach(headA,headB);
    }

    private ListNode twoPointerApproach(ListNode head1, ListNode head2){
        if(head1==null || head2 == null) return null;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while(p1!=p2){
            p1 = (p1!=null)?p1.next:head2;
            p2 = (p2!=null)?p2.next:head1;
        }
        return p1; //p2
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