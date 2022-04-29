package com.andrewbayd;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

https://leetcode.com/problems/ransom-note/
 */

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote note = new RansomNote();
        System.out.println(note.canConstruct("a", "b")); //-> false
        System.out.println(note.canConstruct("aa", "ab")); //-> false
        System.out.println(note.canConstruct("aa", "abba")); //-> true
    }
}
