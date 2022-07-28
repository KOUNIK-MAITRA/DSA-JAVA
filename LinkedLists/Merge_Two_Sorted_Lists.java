import java.io.*;
import java.util.*; 
class Merge_Two_Sorted_Lists
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
  static Node mergeTwoLists(Node l1, Node l2) {
        
        if(l1==null && l2==null)
            return null;
        
        if(l1==null)
            return l2;
        
        if(l2==null)
            return l1;
        
        Node curr_1=l1;
        Node curr_2=l2;
        Node head=new Node(-1);
        Node temp=head;
        
        
        while(curr_1!=null && curr_2!=null)
        {
             
        if(curr_1.data<curr_2.data)
        {
            head.next=new Node(curr_1.data);
            head=head.next;
            curr_1=curr_1.next;
        }
        else 
        {
            head.next=new Node(curr_2.data);
            head=head.next;
            curr_2=curr_2.next;
        }
        
            
        }
        
        while(curr_1!=null)
        {
             head.next=new Node(curr_1.data);
            head=head.next;
            curr_1=curr_1.next;
        }
        
        while(curr_2!=null)
        {
            
            head.next=new Node(curr_2.data);
            head=head.next;
            curr_2=curr_2.next;
        }
        
        return temp.next;
        
    }
    public static void main(String args[]){
     Node head1=new Node(1);
     head1.next=new Node(2);
     head1.next.next=new Node(3);
     head1.next.next.next=new Node(5);
     head1.next.next.next.next=new Node(10);
     
     Node head2=new Node(1);
     head2.next=new Node(4);
     head2.next.next=new Node(7);
     head2.next.next.next=new Node(15);
     head2.next.next.next.next=new Node(30);
     
     Node head=mergeTwoLists(head1,head2);
     display(head);
     
    }
}
