package com.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * 
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 */


public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerMap.containsKey(nums[i])) {
                indexs[0] = integerMap.get(nums[i]);
                indexs[1] = i;
                return indexs;
            }
            integerMap.put(target - nums[i], i);
        }
        return indexs;
    }

    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        int[] res = twoSum(array, 9);
        
        for (int i : res) {
            System.out.println(i);
        }
    }
}
