package com.andrewbayd;

/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return 0;
        int sum = 0;
        int count = 0;
        int[] reminders = new int[k];
        reminders[0] = 1;
        for (int num : nums) {
            sum += num;
            int reminder = sum % k;
            if (reminder < 0) reminder += k;
            if (reminders[reminder] > 0) count += reminders[reminder];
            reminders[reminder]++;
        }
        return count;
    }
}
