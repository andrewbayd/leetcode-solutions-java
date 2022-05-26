package com.andrewbayd;

/*
https://leetcode.com/problems/robot-bounded-in-circle/
 */
public class RobotInACircle {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        char dir = 'N';
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                if (dir == 'N') y += 1;
                else if (dir == 'S') y -= 1;
                else if (dir == 'E') x += 1;
                else x -= 1;
            }
            if (c == 'L') {
                if (dir == 'N') dir = 'W';
                else if (dir == 'W') dir = 'S';
                else if (dir == 'S') dir = 'E';
                else dir = 'N';
            }
            if (c == 'R') {
                if (dir == 'N') dir = 'E';
                else if (dir == 'E') dir = 'S';
                else if (dir == 'S') dir = 'W';
                else dir = 'N';
            }
        }

        if (x == 0 && y == 0) return true;
        else return dir != 'N';
    }
}
