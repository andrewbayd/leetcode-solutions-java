package com.andrewbayd;

/*
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[first] <= nums[mid]) {
                if (target >= nums[first] && target < nums[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[last]) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); //-> 4
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); //-> -1
    }
}
