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
// LeetCode : 21
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //return iterativeMerge(list1,list2);
        return recursiveMerge(list1,list2);
    }

    // Saturday, February 8, 2025 8:05:38 PM
    // Time Complexity:O(n) | Space Complexity:O(n)
    public ListNode recursiveMerge(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
            if(list1.val<list2.val){
                list1.next=recursiveMerge(list1.next,list2); //<--
                return list1; //<--
            }else{
                list2.next=recursiveMerge(list1,list2.next); //<--
                return list2; //<--
            }
    }

    // Saturday, December 14, 2024 6:50:41 PM
    // T.C - O(n+m) | S.C - O(1)
    public ListNode iterativeMerge(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode dummyNode = new ListNode(-1); 
        ListNode current = dummyNode; //<--
        
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                current.next=list1; 
                list1=list1.next;           
            }else{
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;
        }
        /**
        if(list1!=null){current.next=list1;}
        if(list2!=null){current.next=list2;}
        */
        current.next=(list1!=null)?list1:list2;
        return dummyNode.next; //<--
    }
}