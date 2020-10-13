package com.algorithms.linkedList;

public class text1 {
    public static void main(String[] args) {
        ListNode head;
        ListNode l1=new ListNode(4);

    }
 class ListNode {
     public   int val;
       ListNode next;
    public ListNode(int x) { val = x; }

   }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode temp;
        if(head.next==null){
            return null;
        }
        temp=head.next;
        while(true){
            if(temp.next==null){
                return head;
            }
            if(temp.next.val==val){
                temp.next=temp.next.next;

            }
            temp=temp.next;

        }
    }
}
