package com.andrewbayd;

import com.andrewbayd.datastructures.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(e -> e.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1n1 = new ListNode(1);
        ListNode l1n2 = new ListNode(4);
        ListNode l1n3 = new ListNode(5);
        l1n1.next = l1n2;
        l1n2.next = l1n3;

        ListNode l2n1 = new ListNode(1);
        ListNode l2n2 = new ListNode(3);
        ListNode l2n3 = new ListNode(4);
        l2n1.next = l2n2;
        l2n2.next = l2n3;

        ListNode l3n1 = new ListNode(2);
        ListNode l3n2 = new ListNode(6);
        l3n1.next = l3n2;

        ListNode[] lists = {l1n1, l2n1, l3n1};

        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
