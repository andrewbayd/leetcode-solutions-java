package com.andrewbayd;

import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor == newColor) {
            return image;
        }
        fillPixel(image, sr, sc, currentColor, newColor);
        return image;
    }

    private void fillPixel(int[][] image, int row, int col, int currentColor, int newColor) {
        if (!isValidPixel(image, row, col) || image[row][col] != currentColor || image[row][col] == newColor) {
            return;
        }
        image[row][col] = newColor;
        // Filling all 4-dimensional pixels recursively
        fillPixel(image, row-1, col, currentColor, newColor);
        fillPixel(image, row, col+1, currentColor, newColor);
        fillPixel(image, row+1, col, currentColor, newColor);
        fillPixel(image, row, col-1, currentColor, newColor);
    }

    private boolean isValidPixel(int[][] image, int row, int col) {
        int maxRow = image.length - 1;
        int maxCol = image[0].length - 1;
        return row >= 0 && col >= 0 && row <= maxRow && col <= maxCol;
    }

    public static void main(String[] args) {
        int[][] image1 = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };


        int[][] image2 = {
                {0,0,0},
                {0,1,1}
        };

        FloodFill filler = new FloodFill();
        System.out.println(Arrays.deepToString(filler.floodFill(image1, 1, 1, 2))); //-> [[2, 2, 2], [2, 2, 0], [2, 0, 1]]
        System.out.println(Arrays.deepToString(filler.floodFill(image2, 1, 1, 1))); //-> [[0, 0, 0], [0, 1, 1]]
    }
}
