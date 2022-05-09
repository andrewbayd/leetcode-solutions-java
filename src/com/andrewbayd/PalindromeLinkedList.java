package com.andrewbayd;

import com.andrewbayd.datastructures.ListNode;

/*
Given the head of a singly linked list, return true if it is a palindrome.

https://leetcode.com/problems/palindrome-linked-list/
 */

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // Find a middle point of a list using two pointers
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // Reverse first half of a list
        ListNode rev = head;
        ListNode curr = head.next;
        rev.next = null;
        while (curr != slow) {
            ListNode next = curr.next;
            curr.next = rev;
            rev = curr;
            curr = next;
        }
        // If list has an odd number of nodes move slow pointer one node forward
        if (fast != null) {
            slow = slow.next;
        }
        // Compare lists
        while (slow != null) {
            if (slow.val != rev.val) {
                return false;
            }
            slow = slow.next;
            rev = rev.next;
        }

        return true;
    }
}
