package com.example.List;

//判断链表是否是回文字符串

public class PalindromeList {
    public static void main(String[] args){

        ListNode First= new  ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1,null))));
        ListNode Sencode= new  ListNode(1,new ListNode(2,new ListNode(1,null)));
        ListNode FirstF= new  ListNode(1,new ListNode(2,new ListNode(2,new ListNode(2,null))));
        ListNode SencodeF= new  ListNode(1,new ListNode(2,new ListNode(2,null)));
       System.out.println(  isPalindrome(First)+"=="+isPalindrome(Sencode)+"=="+isPalindrome(FirstF)+"=="+isPalindrome(SencodeF));

    }
    public  static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode p = head;
        int nodeNum =  0;
        while(p != null){ //统计结点的数量
            nodeNum ++;
            p = p.next;
        }
        p = head;
        ListNode p2 = head.next;
        head.next = null;
        for(int i = 1; i < nodeNum/2;i++){ //将前半部分反转，一次改变一个指针。假如说有M个结点，那么有M-1个指针，循环M-1次。
            ListNode tmp = p2.next;
            p2.next = p;
            p = p2;
            p2 = tmp;
        }
        if(nodeNum%2 != 0 && p2 != null){ //考虑奇数的情况，跳过最中间的元素。
            p2 = p2.next;
        }

        while(p != null && p2 != null){ //若只有一个结点，直接跳过
            if(p.val != p2.val){
                return false;
            }
            p = p.next;
            p2 = p2.next;
        }
        return true;
    }
    public static class ListNode {
      int val;
      ListNode next;
     public   ListNode(int x,ListNode next) { val = x; this.next=next;}
  }
}
