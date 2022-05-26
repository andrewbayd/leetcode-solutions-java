package com.andrewbayd;

/*
https://leetcode.com/problems/slowest-key/
 */
public class SlowestKey {
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char slowestKey = keysPressed.charAt(0);
        int longestTime = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int releaseTime = releaseTimes[i] - releaseTimes[i - 1];
            char currKey = keysPressed.charAt(i);
            if (releaseTime > longestTime) {
                longestTime = releaseTime;
                slowestKey = currKey;
            } else if (releaseTime == longestTime && currKey > slowestKey) {
                slowestKey = currKey;
            }
        }
        return slowestKey;
    }

    public static void main(String[] args) {
        slowestKey(new int[]{9, 29, 49, 50}, "cbcd"); //-> c
    }
}
