package com.andrewbayd;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

https://leetcode.com/problems/spiral-matrix/
 */

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> elements = new ArrayList<>();

        int topRow = 0;
        int bottomRow = matrix.length - 1;
        int leftColumn = 0;
        int rightColumn = matrix[0].length - 1;

        while (topRow <= bottomRow && leftColumn <= rightColumn) {
            for (int i = leftColumn; i <= rightColumn; i++) {
                elements.add(matrix[topRow][i]);
            }
            topRow++;

            for (int i = topRow; i <= bottomRow; i++) {
                elements.add(matrix[i][rightColumn]);
            }
            rightColumn--;

            if (topRow <= bottomRow) {
                for (int i = rightColumn; i >= leftColumn; i--) {
                    elements.add(matrix[bottomRow][i]);
                }
            }
            bottomRow--;

            if (leftColumn <= rightColumn) {
                for (int i = bottomRow; i >= topRow; i--) {
                    elements.add(matrix[i][leftColumn]);
                }
            }
            leftColumn++;
        }

        return elements;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix)); //-> [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
