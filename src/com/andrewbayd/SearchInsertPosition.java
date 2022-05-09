package com.andrewbayd;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

https://leetcode.com/problems/search-insert-position/
 */

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int mid = -1;
        while (first <= last) {
            mid = first + (last - first) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) last = mid - 1;
            else first = mid + 1;
        }
        if (nums[mid] < target) return mid + 1;
        else return mid;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3}, 2)); //-> 1
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5)); //-> 2
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2)); //-> 1
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7)); //-> 4
    }
}
