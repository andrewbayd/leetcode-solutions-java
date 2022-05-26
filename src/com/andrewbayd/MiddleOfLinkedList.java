package com.andrewbayd;

import com.andrewbayd.datastructures.ListNode;

/*
Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node.

https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }
}
