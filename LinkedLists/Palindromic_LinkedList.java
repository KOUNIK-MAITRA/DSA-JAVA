import java.io.*;
import java.util.*;
 class Palindromic_LinkedList
{
  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public static void main(String args[])
  {
     ListNode head=new ListNode(1);
     head.next=new ListNode(2);
     head.next.next=new ListNode(2);
     head.next.next.next=new ListNode(2);
     head.next.next.next.next=new ListNode(1);
     
     System.out.println(isPalindrome(head));
     
  }
  static ListNode reverseList(ListNode head)
  {
        ListNode curr=head;
        ListNode prev=null; 
        
        while(curr!=null)
        {
           ListNode temp=curr.next;
           curr.next=prev;
           prev=curr; 
           curr=temp;
        }
        
        return prev;
  }  
  static boolean isPalindrome(ListNode head) 
  {
        
        if(head==null || head.next==null)
            return true;
        
        // find the middle of the linked list
        ListNode slow=head; 
        ListNode fast=head;
       
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        // reverse the 2nd half of the list
        slow.next=reverseList(slow.next);
        slow=slow.next;
        ListNode temp=head;
       
        while (slow!=null){
           
            if(temp.val!=slow.val)
            return false;
           
            slow=slow.next;
            temp=temp.next;
        }
        return true;
    }
}
