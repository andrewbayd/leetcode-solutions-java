package com.andrewbayd;

import java.util.Arrays;

/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

https://leetcode.com/problems/reverse-string/
 */

public class ReverseString {
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        char[] string = {'h', 'e', 'l', 'l', 'o'};
        reverseString(string);
        System.out.println(Arrays.toString(string)); //-> ["o","l","l","e","h"]
    }
}
