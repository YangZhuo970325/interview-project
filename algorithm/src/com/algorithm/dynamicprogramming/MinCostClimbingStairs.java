package com.algorithm.dynamicprogramming;

/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 *
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1：
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[0] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 
 * 示例 2：
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 *
 */

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        /**
         * 思路：使用一个新的数组存放到达该节点的最小长度，最后比较倒数第一个节点和倒数第二个节点的最小值
         * 例如：
         * 1, 100, 1, 1, 1, 100, 1, 1, 100, 1
         *            ||
         *            ||
         * 1, 100, 2, 3, 3, 103, 4, 5, 104, 6
         */
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
        
    }

    public static void main(String[] args) {
        int[] array = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(array));
    }
}
