package com.andrewbayd;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

https://leetcode.com/problems/rotate-image/
 */

import java.util.Arrays;

public class RotateImage {
    // rotate = transpose + reflect
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // base case
        if (n <= 1) {
            return;
        }
        //transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reflect
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
    }
}
