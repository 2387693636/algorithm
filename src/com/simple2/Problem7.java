package com.simple2;

import com.simple1.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: xq2580z
 * @date: 2020/2/13 14:52
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class Problem7 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
    }

    //将数组的值赋给链表
    public ListNode getList(int[] sums) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (int i = 0; i < sums.length; i++) {
            curr.next = new ListNode(sums[i]);
            curr = curr.next;
        }
        return dummyHead.next;
    }

    //将链表的值赋给list并打印
    public void showList(ListNode listNode) {
        List list = new ArrayList();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    public ListNode deleteDuplicates(ListNode listNode){

        ListNode current=listNode;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                ListNode node = current.next;
                current.next = node.next;
                node.next=null; // 清除野指针
            }else {
                current=current.next;
            }
        }
        return listNode;
    }

    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        int[] a = {};
        ListNode list = problem7.getList(a);
        ListNode listNode = problem7.deleteDuplicates(list);
        //打印
        problem7.showList(listNode);
    }
}

