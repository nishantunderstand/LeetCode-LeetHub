// LeetCode:206
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
    public ListNode reverseList(ListNode head) {
        //return reverseApproach(head);
        return stackApproachTUF(head);
    }

    // Tuesday, March 18, 2025 8:03:16 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public ListNode stackApproachTUF(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            st.push(temp.val);
            temp = temp.next;
        }

        // Reset Head
        temp = head;
        while(temp!=null){
            temp.val = st.pop();
            temp = temp.next;
        }
        return head;
    }

    // Tuesday, March 18, 2025 8:03:45 PM
    // Time Complexity:O(n) | Space Complexity:O(1)
    public ListNode reverseApproach(ListNode head) {
        if(head==null){
            return null;
        }
    
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;         
            curr.next = prev;
            prev = curr;
            curr = temp;            
        }
        return prev;
    }
}