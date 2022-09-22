import java.io.*;
import java.util.*;
 class Delete_Nth_Node_from_End
{
  public static void main(String args[])
  {
     ListNode head=new ListNode(1);
     head.next=new ListNode(2);
     head.next.next=new ListNode(3);
     head.next.next.next=new ListNode(4);
     head.next.next.next.next=new ListNode(5);
     int n=2;
     display(removeNthFromEnd(head,n));
     
  }
  static void display(ListNode head)
  { ListNode temp=head;
    while(temp!=null)
    { 
        System.out.print(temp.val+" ");
        temp=temp.next;
    }
    }
  static ListNode removeNthFromEnd(ListNode head, int n) 
  {
    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;
    
    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
  }
  static class ListNode 
  {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }  
}
