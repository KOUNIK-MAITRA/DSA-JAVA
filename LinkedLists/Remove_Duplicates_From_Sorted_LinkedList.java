import java.io.*;
import java.util.*;
class Remove_Duplicates_From_Sorted_LinkedList
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
  static Node deleteDuplicate(Node head){
    if(head==null || head.next==null)
     return head;
      
     Node curr=head;
     while(curr.next!=null)
     { if(curr.data==curr.next.data)
         curr.next=curr.next.next;
       else
        curr=curr.next;
        }
     
    return head;
    }  
  public static void main(String args[])
    {
     Node head=new Node(1);
     head.next=new Node(1);
     head.next.next=new Node(2);
     head.next.next.next=new Node(2);
     head.next.next.next.next=new Node(4);
     
     Node duplicatesRemoved=deleteDuplicate(head);
     display(duplicatesRemoved);
     
    } 
}
