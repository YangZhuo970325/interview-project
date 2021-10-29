package com.algorithm.string;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * 
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 */

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        String res = "";

        for (int i = 0; i < s.length() - 1; i++) {
            // 当回文串是奇数时，由中心向两边扩散
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        String s1 = palindrome(s, s.length() - 1, s.length() - 1);
        res = res.length() > s1.length() ? res : s1;
        return res;
    }

    // 辅助函数:寻找回文串
    private static String palindrome(String s, int left, int right) {
        // 在区间[0, s.length() - 1]中寻找回文串,防止下标越界
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
