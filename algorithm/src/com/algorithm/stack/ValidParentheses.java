package com.algorithm.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * 
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * 
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>(){{
           put(')', '(');
           put(']', '[');
           put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // 如果该值在key值中，则
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek().charValue() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    
}