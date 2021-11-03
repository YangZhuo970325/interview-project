package com.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 */

public class FirstUniqueCharacterInAstring {

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            int count = hashMap.getOrDefault(s.charAt(i), 0);
            hashMap.put(s.charAt(i), count + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
