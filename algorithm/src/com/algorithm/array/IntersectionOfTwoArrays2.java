package com.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 */

public class IntersectionOfTwoArrays2 {

    /**
     * 利用map存放num:次数
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        
        // 使用小的数组存放到map，可以降低空间复杂度
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        
        // 将数组放到map里面 key是数组的值，value是值的次数
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        
        // 遍历数组2,如果在map中可以找到，就设置到输出数组中，并将map的value减一
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    /**
     * 排序+双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,2,1};
        int[] array2 = {2,2};
        int[] array = intersect2(array1, array2);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
