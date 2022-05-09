package com.andrewbayd;

/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

https://leetcode.com/problems/valid-perfect-square/
 */

public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        long first = 1;
        long last = num;
        while (first <= last) {
            long mid = first + (last - first) / 2;
            if (mid * mid == (long)num) return true;
            if (mid * mid > (long)num ) last = mid - 1;
            else first = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16)); //-> true
        System.out.println(isPerfectSquare(14)); //-> false
    }
}