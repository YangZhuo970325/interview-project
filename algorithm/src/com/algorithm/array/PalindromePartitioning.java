package com.algorithm.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len, stack, res);

        return res;
    }

    /**
     * 回溯算法
     * @param charArray 字符串
     * @param index
     * @param len
     * @param path
     * @param res
     */
    private static void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {

        // index == len 说明前面的字符串已经遍历完了，并且将回文字串放在了path中
        if (index == len) {
            res.add(new ArrayList<>(path));
        }

        // 遍历剩余的字符串
        // 例如全部字符串是aabb,剩余字符串是abb
        // i = 1, index = 1, len = 4 则判断'a'是不是回文串  --------- i = 2, index = 2, len = 4, 则判断'b'是否是回文串,然后判断剩余的'b'是否是回文串
        //                                               --------- i = 3, index = 2, len = 4, 则判断'bb'是否是回文串
        // i = 2, index = 1, len = 4 则判断'ab'是不是回文串，如果是，剩余的'b'继续进行相关判断，如果不是，直接进入下一个循环体
        // i = 3, index = 1, len = 4,则判断'abb'是不是回文串
        // i = 4, index = 1, len = 4,此时path变量的值为[[a],[a],[b],[b]],
        // i = 2, index = 2, len = 4,则判断'b'是不是回文串  --------- i = 3, index = 3, len = 4, 则判断'b'是否是回文串
        // i = 3, index = 2, len = 4,则判断'bb'是不是回文串
        for (int i = index; i < len; i++) {
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path, res);
            /**
             * 第一次遍历到最后一个元素后的path的状态为['a','a','b','b']
             * 然后删掉最后一个元素['a','a','b'],不能形成回文字串，继续删除最后一个元素['a','b']
             */
            path.removeLast();
        }
    }

    /**
     * 判读字串是否是回文串
     * @param charArray
     * @param left
     * @param right
     * @return
     */
    private static boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static List<List<String>> partition2(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        char[] charArray = s.toCharArray();
        // 预处理
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                // 左边字符与右边字符相等，且[(右边减左边小于等于2(等于2就说明这个字串是三个字符的)) 或 (除当前左、右字符的字串是回文串)]
                if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        dfs2(s, 0, len,dp, stack, res);
        return res;
    }

    private static void dfs2(String s, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // 当index--i是回文串时，将当前index--i加入path中，然后剩余的字符串继续递归进行回文串判断
            if (dp[index][i]) {
                path.addLast(s.substring(index, i + 1));
                dfs2(s, i + 1, len, dp, path, res);
                path.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(partition2("aabb"));
    }

}
