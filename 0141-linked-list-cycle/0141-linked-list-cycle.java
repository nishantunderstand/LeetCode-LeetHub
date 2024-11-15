/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
Friday, November 15, 2024 2:58:56 PM
T.C - O(n)
S.C - O(n)
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        return hashMapApproach(head);        
    }
    public boolean hashMapApproach(ListNode head){
        if(head==null) return false;
        HashMap<ListNode,Integer> hm = new HashMap<>();
        while(head!=null){
            if(hm.containsKey(head)) return true;
            hm.put(head,1);
            head = head.next;
        }
        return false;
    }
}