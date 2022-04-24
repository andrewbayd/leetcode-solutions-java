package com.andrewbayd;

public class Sqrt {

    /*
    Given a non-negative integer x, compute and return the square root of x.
    Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
    Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
    The full description: https://leetcode.com/problems/sqrtx/
    */

    public static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;

        int start = 0;
        int end = x;
        int res = 2;

        while (start < end) {
            long mid = (start + end) / 2;
            if ((mid*mid <= x) && ((mid+1) * (mid+1) > x)) {
                return (int)mid;
            } else if (mid*mid > x) {
                end = (int)mid;
            } else {
                start = (int)mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        assert mySqrt(0) == 0;
        assert mySqrt(3) == 1;
        assert mySqrt(8) == 2;
        assert mySqrt(2147395599) == 46339;
    }
}
