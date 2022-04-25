package com.andrewbayd;

public class ClimbStairs {

    /*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    https://leetcode.com/problems/climbing-stairs/
     */

    public static int climbStairs(int n) {
        int x = 1;
        int y = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = x;
            x = x + y;
            y = temp;
        }

        return x;
    }

    public static void main(String[] args) {
        assert climbStairs(2) == 2;
        assert climbStairs(3) == 3;
        assert climbStairs(5) == 8;
    }
}
