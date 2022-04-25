package com.andrewbayd;

public class MissingNumber {

    /*
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

    https://leetcode.com/problems/missing-number/
     */

    public static int missingNumber(int[] nums) {

        int n = nums.length;
        int sumArr = 0;
        int sumFull = n;

        for (int i = 0; i < n; i++) {
            sumArr += nums[i];
            sumFull += i;
        }

        return sumFull - sumArr;
    }

    public static void main(String[] args) {
        assert missingNumber(new int[]{3,0,1}) == 2;
        assert missingNumber(new int[]{0,1}) == 3;
        assert missingNumber(new int[]{9,6,4,2,3,5,7,0,1}) == 8;
    }
}
