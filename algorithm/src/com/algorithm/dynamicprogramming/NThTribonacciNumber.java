package com.algorithm.dynamicprogramming;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列Tn定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 
 * 示例 2
 * 输入：n = 25
 * 输出：1389537
 */
public class NThTribonacciNumber {

    public static int tribonacci(int n) {
        if (n < 2) {
            return n;
        } else if (n == 2) {
            return 1;
        } else {
            int a = 0, b = 1, c = 1, d = 0, i = 0;
            while (i < n - 2) {
                d = a + b + c;
                a = b;
                b = c;
                c = d;
                i++;
            }
            return d;
        }
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }
}
