package com.algorithm.dynamicprogramming;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 */

public class FibonacciNumber {

    /**
     * 递归，代码少，时间复杂度较高
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibExchange(int n) {
        if (n < 2) {
            return 1;
        }
        
        int a = 0,b = 1,c = 0, i = 0;
        while (i <= n - 2) { // 设置值就是第一次
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(fibExchange(2));
    }

}
