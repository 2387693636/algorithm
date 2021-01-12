package com.simple2;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: xq2580z
 * @date: 2020/2/14 13:23
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class Problem9 {


    class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            this.val=x;
        }
    }


    //将数组的值赋给链表
    public ListNode getList(int[] sums) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (int sum : sums) {
            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        return dummyHead.next;
    }

    //将链表的值赋给list并打印
    public void showList(ListNode listNode) {
        ArrayList list = new ArrayList();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    public ListNode addTwoListNodeNum(ListNode l1, ListNode l2) {
        // 预先指针
        ListNode pre = new ListNode(0);
        //cur指向预先指针
        ListNode cur=pre;
        //进位
        int carry=0;

        //遍历链表
        while (l1 != null || l2 != null) {

            int x= l1==null ? 0:l1.val;
            System.out.println("l1.val :"+l1.val);

            int y= l2==null ? 0:l2.val;
            System.out.println("l1.val "+l2.val);
            int sum=x+y+carry;
            carry=sum/10;

            sum=sum%10;
            System.out.println("sum "+sum);
            cur.next = new ListNode(sum);
            cur=cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        // 进位为1
        if (carry > 0 ) {
            cur.next = new ListNode(carry);
        }
        return pre.next;

    }

    public static void main(String[] args) {
        Problem9 problem9 = new Problem9();
        int[] a={1,8};
        int[] b = {0};
        ListNode list1 = problem9.getList(a);
        ListNode list2 = problem9.getList(b);

        ListNode listNode = problem9.addTwoNumbers(list1, list2);
        problem9.showList(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}