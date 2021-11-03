package com.algorithm.array;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int[][] array = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[i][j] = matrix[i][j];
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    
                    // 先遍历一列，设置数组值
                    for (int p = 0; p < matrix.length; p++) {
                        array[p][j] = 0;
                    }

                    // 再遍历一行，设置数组值
                    for (int k = 0; k < matrix[0].length; k++) {
                        array[i][k] = 0;
                    }
                    
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = array[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] array1 = {{1,1,1}, {1,0,1}, {1,1,1}};
        setZeroes(array1);
    }
}
