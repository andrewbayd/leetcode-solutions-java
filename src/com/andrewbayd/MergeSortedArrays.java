package com.andrewbayd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.

https://leetcode.com/problems/merge-sorted-array/
 */

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) return;

        List<Integer> temp = new ArrayList<>();

        int first = 0;
        int second = 0;

        for (int i = 0; i < n + m; i++) {
            if (first < m && (second == n || nums1[first] <= nums2[second])) {
                temp.add(nums1[first++]);
            } else {
                temp.add(nums2[second++]);
            }
        }

        for (int i = 0; i < n + m; i++) {
            nums1[i] = temp.get(i);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1)); //-> [1, 2, 2, 3, 5, 6]
    }
}
