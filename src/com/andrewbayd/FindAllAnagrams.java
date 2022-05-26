package com.andrewbayd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */

public class FindAllAnagrams {
    public static List<Integer> findAllAnagrams(String original, String check) {
        List<Integer> res = new ArrayList<>();
        if (check.length() > original.length()) {
            return res;
        }
        HashMap<Character, Integer> checkMap = new HashMap<>();
        HashMap<Character, Integer> currentMap = new HashMap<>();
        int slow = 0;
        int fast = check.length() - 1;
        for (int i = 0; i < check.length(); i++) {
            checkMap.put(check.charAt(i), checkMap.getOrDefault(check.charAt(i), 0) + 1);
            currentMap.put(original.charAt(i), currentMap.getOrDefault(original.charAt(i), 0) + 1);
        }
        while (fast < original.length()) {
            if (currentMap.equals(checkMap)) res.add(slow);
            if (currentMap.get(original.charAt(slow)) == 1) {
                currentMap.remove(original.charAt(slow));
            } else {
                currentMap.put(original.charAt(slow), currentMap.get(original.charAt(slow)) - 1);
            }
            slow++;
            fast++;
            if (fast < original.length()) {
                currentMap.put(original.charAt(fast), currentMap.getOrDefault(original.charAt(fast), 0) + 1);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAllAnagrams("cbaebabacd", "abc")); //-> [0, 6]
    }
}
