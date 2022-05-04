package com.andrewbayd;

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

https://leetcode.com/problems/implement-strstr/
 */

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() <= haystack.length() && haystack.startsWith(needle, i)) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        StrStr str = new StrStr();
        System.out.println(str.strStr("hello", "ll")); //->2
        System.out.println(str.strStr("a", "a")); //->0
        System.out.println(str.strStr("mississippi", "issip")); //->4
        System.out.println(str.strStr("aa", "aaa")); //->-1
        System.out.println(str.strStr("aaa", "")); //->0
    }
}
