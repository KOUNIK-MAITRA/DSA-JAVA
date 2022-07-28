import java.io.*;
import java.util.*;
 class Cycle_In_A_LinkedList_II
{
    static class Node{
     int data;
     Node next;
     Node(int data){
      this.data=data;
      this.next=null;
     }
    }
     static Node detectCycle(Node head) {
        if(head==null || head.next==null)
            return null;
        
        Node slow=head;
        Node fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast)
            {
                slow=head;
                while(slow!=fast)
                {
                    slow=slow.next;
                    fast=fast.next;
                
                }
                return fast;                
            }
        }
        return null;
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
     
     System.out.println("The cycle starts at node " + detectCycle(head).data);
     
    }
}
