package com.algorithm.dynamicprogramming;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶 
 */

/**
 * 思路1(排列组合)：
 * 如果是6阶楼梯，算法为：
 * 1 1 1 1 1 1  =======> C6(0)          =
 * 2 1 1 1 1                            =
 * 1 2 1 1 1                            =
 * 1 1 2 1 1    =======> C5(1)          =
 * 1 1 1 2 1                            =
 * 1 1 1 1 2                            =
 * 2 2 1 1                              ========>   C6(0) + C5(1) + C4(2) + C3(3)
 * 2 1 2 1                              =                       ||
 * 2 1 1 2      =======> C4(2)          =                       ||
 * 1 2 2 1                              =                       ||
 * 1 2 1 2                              =       Cn(0) + Cn-1(1) + Cn-2(2) + Cn-i(i)   [n-i > i]         
 * 1 1 2 2                              =
 * 2 2 2        =======> C3(3)          =
 * 
 * bug: 后续算阶乘的时候，int类型和long类型都无法存放阶乘的值（数值越界）
 * 
 * 
 * 思路二（动态规划）：
 * 第n阶台阶是从【第n-1阶爬一阶】或者【第n-2阶爬两阶】  =====> step(n) = step(n-1) + step(n-2)
 * 第n-1阶是从【第n-2阶爬一阶】或者第【第n-3阶爬两阶】  =====> step(n-1) = step(n-2) + step(n-3)
 *                       .
 *                       .
 * 第3阶是从【第2阶爬一阶】或者第【第1阶爬两阶】  =====> step(3) = step(2) + step(1)
 * 第2阶                                   =====> step(2) = 2
 * 第1阶                                   =====> step(1) = 1
  */

public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n == 1) {return 1;}
        if (n == 2) {return 2;}
        int a = 1, b = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
