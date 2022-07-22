import java.io.*;
import java.util.*;
 class Partition_Linked_List
{
   static class Node{
     int data;
     Node next;
     Node(int data){
      this.data=data;
      this.next=null;
     }
    }
    
   static Node partition(Node head, int x) {
        Node left=new Node(-1);
        Node right=new Node(-1);
        Node leftEnd=left;
        Node rightEnd=right;
        
        Node curr=head;
        
        while(curr!=null){
            
            if(curr.data<x){
             leftEnd.next=curr;
                leftEnd=leftEnd.next;
            }
            else{
               rightEnd.next=curr;
                rightEnd=rightEnd.next;
            }
            
            curr=curr.next;
        }
        
        leftEnd.next=right.next;
        rightEnd.next=null;
        
        return left.next;
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
     head.next=new Node(4);
     head.next.next=new Node(3);
     head.next.next.next=new Node(2);
     head.next.next.next.next=new Node(5);
     head.next.next.next.next.next=new Node(2);
     int x=3;
     display(partition(head,x));
    } 
}
