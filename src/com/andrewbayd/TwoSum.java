package com.andrewbayd;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    The full description: https://leetcode.com/problems/two-sum/
     */

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> passed = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (passed.containsKey(target - nums[i])) {
                result[0] = passed.get(target - nums[i]);
                result[1] = i;
                break;
            }
            passed.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 11, 7, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9))); //-> [0, 2]
    }
}
