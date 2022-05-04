package com.andrewbayd;

import java.util.Arrays;

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
Increment the large integer by one and return the resulting array of digits.

https://leetcode.com/problems/plus-one/
 */

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        int add = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digits[i]++;
            }
            if (add == 1) {
                digits[i]++;
                add--;
            }
            if (digits[i] >= 10) {
                digits[i] = digits[i] % 10;
                add++;
            }
        }

        if (add == 0) {
            return digits;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < result.length - 1; i++) {
            result[i] = digits[i - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 4}))); //-> [1, 2, 5]
        System.out.println(Arrays.toString(plusOne(new int[]{2, 6, 9}))); //-> [2, 7, 0]
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9}))); //-> [1, 0, 0]
    }
}
