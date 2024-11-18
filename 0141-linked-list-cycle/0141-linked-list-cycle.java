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


public class Solution {
    public boolean hasCycle(ListNode head) {
        //return hashMapApproach(head);        
        //return hashSetApproach(head);  
        return fastAndSlow(head);    
    }


    public boolean fastAndSlow(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    // Monday, November 18, 2024 9:27:32 PM
    // T.C - O(n) | S.C - O(n/)
    public boolean hashSetApproach(ListNode head){
        if(head==null) return false;
        HashSet<ListNode> hs = new HashSet<>();
        while(head!=null){
            if(hs.contains(head)) return true;
            hs.add(head);
            head = head.next;
        }
        return false;
    }

    // Monday, November 18, 2024 9:27:38 PM
    // T.C - O(n) | S.C - O(n)
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