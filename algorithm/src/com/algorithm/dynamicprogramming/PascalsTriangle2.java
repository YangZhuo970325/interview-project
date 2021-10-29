package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 * 
 * 示例 3:
 * 输入: rowIndex = 1
 * 输出: [1,1]
 */

public class PascalsTriangle2 {

    public static List<Integer> getRow(int rowIndex) {

        Integer[] array = new Integer[rowIndex + 1];

        Arrays.fill(array, 1);
        
        for (int i = 2; i < array.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                array[j] = array[j] + array[j - 1];
            }
        }

        List<Integer> list = Arrays.asList(array);
        return list;

    }

    public static void main(String[] args) {
        System.out.println(getRow(5));
    }
    
    
}
