package com.algorithm.list;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。 
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null; //记录前指针节点
        ListNode curr = head; //记录当前节点
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
            
        }
        return prev;
    }

    private class ListNode { 
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
