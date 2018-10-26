package com.example.List;


/**
 * 链表删除指定倒数第几个位置的节点
 * 两个指针，快指针先走n步，再快慢指针同时往后走  直到快指针到达尾节点 将此时慢节点的下一个节点删除 即可
 * 原理：
 * 总长度为X,先走N步，再到达尾节点，则此时慢指针走了X-N步，下一个就是倒数第N个数据
 */
public class RemoveListCode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        ListNode listNode = removeNthFromEnd(head, 4);
        System.out.println(listNode.toString());
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode preNode = head;
        ListNode curNode = head;

        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }

        if (curNode == null) {
            return preNode.next;
        }

        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }

        preNode.next = preNode.next.next;

        return head;
    }




    static class ListNode {
        int val;

        @Override
        public String toString() {
            return
                     val +"-->"+
                    next ;
        }

        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
