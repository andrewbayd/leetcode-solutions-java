package com.andrewbayd;

public class BinarySearch {

    /*
    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
    You must write an algorithm with O(log n) runtime complexity.

    https://leetcode.com/problems/binary-search/
     */

    public static int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};

        System.out.println(search(arr, 9)); //-> 4
        System.out.println(search(arr, 2)); //-> -1
    }
}
