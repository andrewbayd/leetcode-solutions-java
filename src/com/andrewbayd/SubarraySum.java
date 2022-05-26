package com.andrewbayd;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray
of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class SubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            sum += nums[fast];
            fast++;
            while (sum >= target) {
                res = Math.min(res, fast - slow);
                sum -= nums[slow];
                slow++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
