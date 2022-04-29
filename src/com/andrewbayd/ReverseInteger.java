package com.andrewbayd;

/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

https://leetcode.com/problems/reverse-integer/
 */

public class ReverseInteger {
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int res = 0;
        while (x != 0) {
            int last = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10
                    || res < Integer.MIN_VALUE / 10
                    || res == Integer.MAX_VALUE / 10 && last > 7
                    || res == Integer.MIN_VALUE / 10 && last < -8) {
                return 0;
            }
            res = res * 10 + last;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123)); //-> 321
        System.out.println(reverse(-321)); //-> -123
        System.out.println(reverse(1463847412)); //-> 2147483641
        System.out.println(reverse(1563847412)); //-> 0
    }
}
