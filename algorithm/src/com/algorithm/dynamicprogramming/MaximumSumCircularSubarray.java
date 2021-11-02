package com.algorithm.dynamicprogramming;

/**
 * 918. 环形子数组的最大和
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 *
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。
 * （形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 *
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。
 * （形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 *
 * 示例 1：
 * 输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 
 * 示例 2：
 * 输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * 
 * 示例 3：
 * 输入：[3,-1,2,-1]
 * 输出：4
 * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 * 
 * 示例 4：
 * 输入：[3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 * 
 * 示例 5：
 * 输入：[-2,-3,-1]
 * 输出：-1
 * 解释：从子数组 [-1] 得到最大和 -1
 */

public class MaximumSumCircularSubarray {

    public static int maxSubarraySumCircular(int[] nums) {

        /**
         * 如果是不跨两边最大，则按照正常算法，得出max，并将数组求和，方便后面减最小值，算出跨两边的最大值
         */
        int dp = nums[0], max = dp, sum = dp, min = 0;
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }

        /**
         * 如果跨两边，则说明最小值在中间（不可能在最两边），则找到中间的最小值
         */
        dp = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp = Math.min(dp + nums[i], nums[i]);
            min = Math.min(dp, min);
        }
        return Math.max(sum - min, max);
    }

    public static void main(String[] args) {
        int[] array = {-2,-3,-1};
        System.out.println(maxSubarraySumCircular(array));
    }
}
