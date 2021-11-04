package com.algorithm.dynamicprogramming;

/**
 * 1014. 最佳观光组合
 * 
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 * 
 * 示例 1：
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * 示例 2：
 * 输入：values = [1,2]
 * 输出：2
 * 
 */

public class BestSightseeingPair {

    /**
     * 思路：遍历数组
     * values[i] + values[j] + i - j  ===> values[i] + i + values[j] - j
     *
     */
    public static int maxScoreSightseeingPair(int[] values) {
        int left = values[0], res = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, left + values[i] - i);
            left = Math.max(left, values[i] + i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(array));
    }
}
