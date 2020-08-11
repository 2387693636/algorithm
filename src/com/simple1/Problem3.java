package com.simple1;

/**
 * @auther: xq2580z
 * @date: 2020/2/5 10:48
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Problem3 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next=l1;
                l1=l1.next;
            }
            else {
                prev.next=l2;
                l2=l2.next;

            }
            prev=prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

    public  ListNode buildListNode(int[] input){
        ListNode first = null,last = null,newNode;
        int num;
        if(input.length>0){
            for(int i=0;i<input.length;i++){
                newNode=new ListNode(input[i]);
                newNode.next=null;
                if(first==null){
                    first=newNode;
                    last=newNode;
                }
                else{
                    last.next=newNode;
                    last=newNode;
                }

            }
        }
        return first;
    }

    class ListNode{
        int val ;
        ListNode next;

        ListNode(int x) {
            this.val=x;
        }
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        int[] a = new int[]{1, 2, 5, 6, 9, 55};
        int [] b=new int[]{1,2,5,8,9};
        ListNode l1=problem3.buildListNode(a);
        ListNode l2=problem3.buildListNode(b);

        ListNode listNode = problem3.mergeTwoLists(l1, l2);
        System.out.println(listNode);


        while(listNode!=null){
            System.out.println("val"+listNode.val+"/listNode"+listNode.next);
            listNode=listNode.next;
        }

    }
}

