package com.algorithm.stack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * 
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 */

public class MyQueue {
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        // push的时候直接压到stack1里面
        if (stack1.empty()) {
            front = x;
        }
        stack1.push(x);
    }

    public int pop() {
        // pop的时候,先判断stack2是不是空的,如果不是空,stack2直接pop
        // 如果stack2是空，而且stack1不是空，则将stack1的元素先搬到stack2,再从stack2中pop
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    
    public int peek() {
        // 如果stack2不是空,则从stack2中取数据
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        // 如果stack2是空的，直接返回front(front记录最先入栈的值)
        return front;
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
