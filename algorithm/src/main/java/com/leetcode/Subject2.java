package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author rxt
 * @version 1.0
 * @date 2021/5/11 22:31
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 */
public class Subject2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 9;
        ListNode l2 = new ListNode();
        l2.val = 4;
        ListNode l3 = new ListNode();
        l3.val = 3;
        ListNode l4 = new ListNode();
        l4.val = 1;
        ListNode l5 = new ListNode();
        l5.val = 9;
        ListNode l6 = new ListNode();
        l6.val = 9;
//        l1.next = l2;
//        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        Subject2 subject2 = new Subject2();
        ListNode listNode = subject2.addTwoNumbers(l1, l4);
        System.out.println(listNode);

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList list1 = formatIntArray(l1);
        ArrayList list2 = formatIntArray(l2);
        int[] sum = getSum(list1, list2);
        ListNode listNode = new ListNode();
        ListNode listNode1 =  listNode;
        for (int i = 0; i <sum.length ; i++) {
            listNode.val = sum[i];
            if (i == sum.length-1){
                continue;
            }
            listNode.next = new ListNode();
            listNode = listNode.next;
        }
        return listNode1;

    }

    private int[] getSum(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if (list1.size() == 0 && list2.size()==0 ){
            return new int[0];
        }
        ArrayList<Integer> maxL = list1.size()>list2.size()?list1:list2;
        ArrayList<Integer> minL = list1 ==maxL ? list2:list1;
        int max = maxL.size();
        int min = minL.size();
        int[] ints = new int[max];
        int add = 0;
        for (int i =0; i  < maxL.size() ; i++) {
            if (min<=i){
                if (add > 0){
                    int sum =  maxL.get(i) + add;
                    if (sum >= 10){
                        add = 1;
                        String s =  String.valueOf(sum);
                        ints[i] = Integer.valueOf(s.charAt(s.length()-1)-48);
                    }else {
                        add = 0;
                        ints[i] = sum;
                    }
                }else {
                    ints[i] = maxL.get(i);
                }
            }else{
                int sum =  maxL.get(i)+minL.get(i)+add;
                if (sum >= 10){
                    add = 1;
                    String s =  String.valueOf(sum);
                    ints[i] = Integer.valueOf(s.charAt(s.length()-1)-48);
                }else {
                    add = 0;
                    ints[i] = sum;
                }
            }
        }
        if (add > 0){
           int[] copy =  new int[ints.length+1];
            for (int i = 0; i < ints.length; i++) {
                copy[i] = ints[i];
            }
            copy[ints.length] = add;
            return copy;
        }
        return ints;
    }

    private ArrayList formatIntArray(ListNode l1) {
        ArrayList<Integer> list = new ArrayList<>();
        while(l1 != null){
            list.add(l1.val);
            l1 = l1.next;
        }
        return list;
    }


}
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
