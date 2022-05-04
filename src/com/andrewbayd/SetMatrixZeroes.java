package com.andrewbayd;

import java.util.Arrays;

/*
Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

https://leetcode.com/problems/set-matrix-zeroes/
 */

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean isFirstRow = false;
        boolean isFirstColumn = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0 && !isFirstRow) {
                        isFirstRow = true;
                    }
                    if (j == 0 && !isFirstColumn) {
                        isFirstColumn = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstRow) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isFirstColumn) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,0,7,8}, {0,10,11,12},{13,14,15,0}};
        setZeroes(matrix);
        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
    }
}
