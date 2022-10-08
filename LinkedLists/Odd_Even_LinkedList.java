import java.io.*;
import java.util.*;
class Odd_Even_LinkedList
{
    public static void main(String args[])
    {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        
        display(oddEvenList(head));
    }
    static void display(ListNode head)
    {
        while(head!=null)
        {
            System.out.print(head.data+"-->");
            head=head.next;
        }
        System.out.print("null");
    }
    static ListNode oddEvenList(ListNode head)
    {
        if(head==null) return head;
        
        ListNode odd=head;
        ListNode even=odd.next;
        ListNode evenHead=even;
        while(odd.next!=null && even.next!=null)
        {
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        if(even!=null)
            even.next=null;
        odd.next=evenHead;    
        
        return head;
    }
    static class ListNode
    {
        int data;
        ListNode next;
        ListNode(int data)
        {
            this.data=data;
            next=null;
        }
    }
}
