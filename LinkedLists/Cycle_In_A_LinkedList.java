import java.io.*;
import java.util.*;
 class Cycle_In_A_LinkedList
{
    static class Node{
     int data;
     Node next;
     Node(int data){
      this.data=data;
      this.next=null;
     }
    }
     static boolean detectCycle(Node head) {
        if(head==null || head.next==null)
            return false;
        
        Node slow=head;
        Node fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast)
            return true;
        }
        return false;
    }
     static void display(Node head){
     while(head!=null)
     { System.out.print(head.data+" --> ");
         head=head.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String args[]){
     Node head=new Node(1);
     head.next=new Node(2);
     head.next.next=new Node(3);
     head.next.next.next=new Node(4);
     head.next.next.next.next=head.next.next;
     
     System.out.println("Cycle Present " + detectCycle(head));
     
    }
}
