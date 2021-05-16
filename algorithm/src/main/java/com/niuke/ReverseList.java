package com.niuke;

/**
 * @author rxt
 * @version 1.0
 * @date 2021/5/16 22:48
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 1; i < 4; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        ListNode listNode = reverseList.ReverseList(head);
        while (listNode!= null){
            System.out.println(listNode.val);

            listNode = listNode.next;
        }

    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;

    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
