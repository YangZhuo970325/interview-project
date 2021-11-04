package com.algorithm.dynamicprogramming;

/**
 * 122. 买卖股票的最佳时机 II
 * 
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 
 * 示例 2:
 * 输入: prices = [1,2,3,4,5]
 * 输出: 4
 */

public class BestTimeToBuyAndSellStock2 {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit = profit + prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        System.out.println(maxProfit(array));
    }
}
