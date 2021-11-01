package com.algorithm.dynamicprogramming;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * 
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 */

public class JumpGame2 {

    public static int jump(int[] nums) {
        // 记录当前需要达到的目标值
        int reach = 0;
        // 存放下一次需要到达的最远的地方
        int nextReach = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 计算之前已经算出的最远值 与 当前节点可以到达的最远值
            nextReach = Math.max(i + nums[i], nextReach);
            // 如果已经大于数组长度，则已经到达最远节点
            if (nextReach >= nums.length - 1) {
                return step + 1;
            }
            // 当前位置 与 当前需要达到的位置 相等
            if (reach == i) {
                // 将最远值设置为当前目标值
                reach = nextReach;
                // 因为本次已经到达，则step+1
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int array[] = {2,3,0,1,4,1,1,5,1,2,3,4,1};
        System.out.println(jump(array));
    }
}
