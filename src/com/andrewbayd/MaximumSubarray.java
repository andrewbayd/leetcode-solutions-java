package com.andrewbayd;

public class MaximumSubarray {


    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        int maxSum = nums[0];
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4})); //-> 6
        System.out.println(maxSubArray(new int[]{1})); //-> 1
        System.out.println(maxSubArray(new int[]{-2,-3,-1})); //-> -1
    }
}
