package com.andrewbayd;

import java.util.HashSet;

public class ContainsDuplicate {

    /*
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    https://leetcode.com/problems/contains-duplicate/
     */

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> passedElements = new HashSet<>();
        for (int num : nums) {
            if (passedElements.contains(num)) {
                return true;
            }
            passedElements.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        assert containsDuplicate(new int[]{1, 2, 3, 1});
        assert !containsDuplicate(new int[]{1, 2, 3, 4});
        assert containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});
    }
}
