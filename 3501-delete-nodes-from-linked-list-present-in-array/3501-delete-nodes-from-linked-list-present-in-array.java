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
// LeetCode : 3217
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {    
        return setListApproach(nums,head);
    }

    // Saturday, November 1, 2025 11:56:13 AM
    // Time Complexity:O(n)+O(n) | Space Complexity:O(n)
    private ListNode setListApproach(int[] nums, ListNode head) {
        if(head==null || nums==null || nums.length==0){
            return head;
        }

        Set<Integer> deleteSet = new HashSet<>();
        for(int num : nums){
            deleteSet.add(num);
        }

        ListNode dummy = new ListNode(-1,head);  //<--
        ListNode curr = dummy;
        while(curr.next!=null){  //<--
            if(deleteSet.contains(curr.next.val)){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}