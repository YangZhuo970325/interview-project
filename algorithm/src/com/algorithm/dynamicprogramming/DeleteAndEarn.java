package com.algorithm.dynamicprogramming;

/**
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 *
 * 示例 2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 */

public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        
        int[] trans = new int[10000];
        
        for (int i = 0; i < nums.length; i++) {
            trans[nums[i]] = trans[nums[i]] + nums[i];
        }
        
        int dp[] = new int[10000];
        dp[0] = 0;
        dp[1] = trans[1];
        
        for (int i = 2; i < trans.length; i++) {
            dp[i] = Math.max(dp[i - 2] + trans[i], dp[i - 1]);
        }
        return dp[trans.length - 1];
    }

    public static void main(String[] args) {
        int[] array = {3,4,2};
        System.out.println(deleteAndEarn(array));
    }
}
