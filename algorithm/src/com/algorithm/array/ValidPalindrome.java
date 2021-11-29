package com.algorithm.array;

import java.util.Locale;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 */
public class ValidPalindrome {

    /**
     * 双向指针思路，现转成小写，然后使用一个指向第一个数，一个指向最后一个，遇到特殊符号就移动
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase(Locale.ROOT);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        String actual = s.replace("[^A-Za-z0-9]", "").toLowerCase(Locale.ROOT);
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome2(s));
    }
}
