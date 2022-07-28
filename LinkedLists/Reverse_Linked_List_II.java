import java.io.*;
import java.util.*;
 class Reverse_Linked_List_II
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
      static Node reverseBetween(Node head, int left, int right) {
        
        Node dummy=new Node(0);
        dummy.next=head;
        Node curr=head;
        Node prev =null;
        Node leftPrev=dummy;
        
        for(int i=1;i<left;i++){
            leftPrev=curr;
            curr=curr.next;

        }
        
        for(int i=left;i<=right;i++){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        
        leftPrev.next.next=curr;
        leftPrev.next=prev;
        
        return dummy.next;
    }

    public static void main(String args[]){
     Node head=new Node(1);
     head.next=new Node(2);
     head.next.next=new Node(3);
     head.next.next.next=new Node(4);
     head.next.next.next.next=new Node(5);
     
     head=reverseBetween(head,2,4);
     display(head);
     
    }
}
