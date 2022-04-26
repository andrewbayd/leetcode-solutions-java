package com.andrewbayd;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

https://leetcode.com/problems/valid-anagram/
 */

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        for (int i : map.values()) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); //-> true
        System.out.println(isAnagram("rat", "car")); //-> false
    }
}
