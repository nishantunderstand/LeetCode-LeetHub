class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return approach1(list1, list2);
    }

    public ListNode approach1(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify list operations
        ListNode dummy = new ListNode();
        ListNode res = dummy;

        // Merge the two lists until one of them is exhausted
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1; // Attach list1 node to result
                list1 = list1.next; // Move to the next node in list1
            } else {
                res.next = list2; // Attach list2 node to result
                list2 = list2.next; // Move to the next node in list2
            }
            res = res.next; // Move the result pointer
        }

        // Append the remaining nodes of list1 or list2, if any
        if (list1 != null) {
            res.next = list1; // List1 has remaining nodes
        } else if (list2 != null) {
            res.next = list2; // List2 has remaining nodes
        }

        // Return the merged list, skipping the dummy node
        return dummy.next;
    }
}
