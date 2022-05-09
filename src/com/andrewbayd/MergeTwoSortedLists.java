package com.andrewbayd;

import com.andrewbayd.datastructures.ListNode;

/*
Merge the two sorted lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

https://leetcode.com/problems/merge-two-sorted-lists/
 */

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode merged = new ListNode();
        ListNode result = merged;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                merged.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                merged.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            merged = merged.next;
        }

        if (list1 != null) merged.next = new ListNode(list1.val, list1.next);
        if (list2 != null) merged.next = new ListNode(list2.val, list2.next);


        return result.next;
    }
}
