package com.andrewbayd;

import java.util.HashMap;

public class FirstUniqueCharInAString {

    /*
    Given a string s, find the first non-repeating character in it and return its index.
    If it does not exist, return -1.
    The full description: https://leetcode.com/problems/first-unique-character-in-a-string/
     */

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (letters.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        assert firstUniqChar("leetcode") == 0;
    }
}
