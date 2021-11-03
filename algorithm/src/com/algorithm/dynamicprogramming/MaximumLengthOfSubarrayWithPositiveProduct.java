package com.algorithm.dynamicprogramming;

/**
 * 1567. 乘积为正数的最长子数组长度
 * 
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。请你返回乘积为正数的最长子数组长度。
 * 
 * 示例  1：
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * 
 * 示例 2：
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 *
 * 示例 3：
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 * 
 * 示例 4：
 * 输入：nums = [-1,2]
 * 输出：1
 */

public class MaximumLengthOfSubarrayWithPositiveProduct {

    public static int getMaxLen(int[] nums) {
        int res = 0;
        int z = 0, f = 0;
        for (int n : nums) {
            // 如果是0，则重置正负数计数器
            if (n == 0) {
                z = 0;
                f = 0;
            } else if (n > 0) {
                // 如果是正数，则将正数计数器+1，如果负数计数器>0，则负数计数器+1
                z++;
                if (f > 0) {
                    f++;
                }
                res = Math.max(res, z);
            } else {
                // 如果是负数，则将正负数计数器交换，将负数计数器+1，如果正数计数器>0,则将正数计数器+1
                int temp = z;
                z = f;
                f = temp;
                f++;
                if (z > 0) {
                    z++;
                }
                res = Math.max(res, z);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1,-2,-3,4};
        System.out.println(getMaxLen(array));
    }
}
