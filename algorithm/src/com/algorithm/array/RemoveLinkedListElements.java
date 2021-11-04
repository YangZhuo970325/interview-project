package com.algorithm.array;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。 
 * 
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return header.next;
    }
    
    private class ListNode {
        private int val;
        private ListNode next;
        private ListNode() {}
        private ListNode(int val) { this.val = val; }
        private ListNode(int val, ListNode next) {
            this.val = val; 
            this.next = next;
        }
    }
}
