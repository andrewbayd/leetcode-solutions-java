package com.andrewbayd;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    /*
    Classic FizzBuzz: https://leetcode.com/problems/fizz-buzz/
     */

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) result.add("FizzBuzz");
            else if (i % 3 == 0) result.add("Fizz");
            else if (i % 5 == 0) result.add("Buzz");
            else result.add("" + i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(3)); //-> [1, 2, Fizz]
        System.out.println(fizzBuzz(15)); //-> [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
    }
}
