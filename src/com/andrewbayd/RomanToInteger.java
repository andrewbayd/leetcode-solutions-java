package com.andrewbayd;

import java.util.HashMap;

public class RomanToInteger {

    /*
    Convert given roman numeral into integer.
    The full description: https://leetcode.com/problems/roman-to-integer/
     */

    public static int romanToInt(String s) {

        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if ((i != n - 1) && (roman.get(c) < roman.get(s.charAt(i + 1)))) {
                result -= roman.get(c);
            } else {
                result += roman.get(c);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        assert romanToInt("III") == 3;
        assert romanToInt("LVIII") == 58;
        assert romanToInt("MCMXCIV") == 1994;
    }
}
