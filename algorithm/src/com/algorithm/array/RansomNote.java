package com.algorithm.array;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * 
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */

public class RansomNote {

    /**
     * 使用hash表 时间复杂度较高
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct1(String ransomNote, String magazine) {

        Map<Character, Integer> noteMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();
        
        for (int i = 0; i < ransomNote.length(); i++) {
            int count = noteMap.getOrDefault(ransomNote.charAt(i), 0);
            noteMap.put(ransomNote.charAt(i), count + 1);
        }
        
        for (int i = 0; i < magazine.length(); i++) {
            int count = magazineMap.getOrDefault(magazine.charAt(i), 0);
            magazineMap.put(magazine.charAt(i), count + 1);
        }

        for (Map.Entry<Character, Integer> entry : noteMap.entrySet()) {
            char c = entry.getKey();
            if (entry.getValue() > magazineMap.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 因为题目中有说字符串有26个小写字母组成，所以可以用26个长度的int数组来表示（时间复杂度会更低）
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] note = new int[26];
        int[] maga = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            int x = ransomNote.charAt(i) - 'a';
            note[x] = note[x] + 1;
        }

        for (int i = 0; i < magazine.length(); i++) {
            int x = magazine.charAt(i) - 'a';
            maga[x] = maga[x] + 1;
        }

        for (int i = 0; i < 26; i++) {
           if (note[i] > maga[i]) {
               return false;
           }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct2("aa", "aab"));
    }
}
