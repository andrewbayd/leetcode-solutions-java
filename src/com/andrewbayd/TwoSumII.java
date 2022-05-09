package com.andrewbayd;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

import java.util.Arrays;

public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length - 1;
        while (first < last) {
            if (numbers[first] + numbers[last] == target) return new int[]{first + 1, last + 1};
            else if (numbers[first] + numbers[last] < target) first++;
            else last--;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] result2 = twoSum(new int[]{1, 2, 5, 6, 7, 9}, 9);
        System.out.println(Arrays.toString(result1)); //-> [1, 2]
        System.out.println(Arrays.toString(result2)); //-> [2, 5]
    }
}
