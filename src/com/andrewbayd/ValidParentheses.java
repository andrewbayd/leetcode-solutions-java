package com.andrewbayd;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    https://leetcode.com/problems/valid-parentheses/
     */

    public static boolean isValid(String s) {

        Map<Character, Character> map = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (map.containsKey(current)) {
                stack.push(current);
            } else if (stack.isEmpty() || map.get(stack.pop()) != current) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); //-> true
        System.out.println(isValid("([)]")); //-> false
    }
}
