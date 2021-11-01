package com.algorithm.dynamicprogramming;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标
 * 
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 */

public class JumpGame {

    /**
     * 思路：如果数组长度为1或0，一定可以跳到最后一个
     *      采用dp数组，每个元素存放该元素可以到达的最大位置，如果该最大位置大于最后一个元素的位置，则返回true
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (max >= nums.length - 1) {
                return true;
            }
            if (max >= i + 1) {
                dp[i + 1] = nums[i + 1] + i + 1;
                max = Math.max(max, dp[i + 1]);
            }
            
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(canJump(array));
        
    }
}
