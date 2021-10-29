package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 * 
 * 
 */


public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();
        int[][] arrays = new int[numRows][numRows];
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    arrays[i][j] = 1;
                } else {
                    arrays[i][j] = arrays[i-1][j-1] + arrays[i-1][j];
                }
                subList.add(arrays[i][j]);
            }
            lists.add(subList);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
