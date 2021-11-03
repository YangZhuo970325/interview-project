package com.algorithm.array;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 
 */

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        int[] note = new int[26];
        int[] maga = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            note[x] = note[x] + 1;
        }

        for (int i = 0; i < t.length(); i++) {
            int x = t.charAt(i) - 'a';
            maga[x] = maga[x] + 1;
        }

        for (int i = 0; i < 26; i++) {
            if (note[i] != maga[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("a", "ab"));
    }
}
