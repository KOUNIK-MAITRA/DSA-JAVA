import java.io.*;
import java.util.*;
class Remove_Duplicates_From_Sorted_LinkedList_II
{
  static class Node{
     int data;
     Node next;
     Node(int data){
      this.data=data;
      this.next=null;
     }
    }
  static void display(Node head){
     while(head!=null)
     { System.out.print(head.data+" --> ");
         head=head.next;
        }
        System.out.print("null");
        System.out.println();
    }
  static Node deleteDuplicates(Node head) {
       if(head==null || head.next==null)
           return head;
       
        Node dummy=new Node(-1);
        dummy.next=head;
      
        Node curr=head;
        Node prev=dummy;
        Node next=head.next;
      
        while(next!=null)
        {
            if(curr.data==next.data)
            {
               while(next!=null && curr.data==next.data)
                   next=next.next;
                
                curr=next;
                prev.next=curr;
                if(next!=null)
                next=next.next;
            }
            else{
                prev=curr;
                curr=next;
                next=next.next;
            }
        }
        
        return dummy.next;
    }
  public static void main(String args[])
    {
     Node head=new Node(1);
     head.next=new Node(1);
     head.next.next=new Node(2);
     head.next.next.next=new Node(2);
     head.next.next.next.next=new Node(4);
     
     Node duplicatesRemoved=deleteDuplicates(head);
     display(duplicatesRemoved);
     
    } 
}
