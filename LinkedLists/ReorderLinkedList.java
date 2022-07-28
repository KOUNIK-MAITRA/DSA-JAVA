import java.io.*;
import java.util.*;
class ReorderLinkedList
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
     static void reorderList(Node head) {
        Node left=head;
        Node mid=getMid(head);
        Node right=mid.next;
        mid.next=null;
        
        right=reverseList(right);
        
        // left : head-->...mid-->null
        // right :mid.next....-->null
        
        Node ans=merge(left,right);
        head=ans;
        
    }
    
    static Node merge(Node left, Node right){
     Node leftCurr=left;
     Node rightCurr=right;
        
     while(leftCurr!=null && rightCurr!=null){
        Node temp=leftCurr.next;
        leftCurr.next=rightCurr;
        leftCurr=temp;
        
         temp=rightCurr.next;
         rightCurr.next=leftCurr;
         rightCurr=temp;
         
     }   
      return left;  
    }
    
    static Node reverseList(Node head){
        Node curr=head;
        Node prev=null;
        
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        
        return prev;
    }
    
    static Node getMid(Node head){
        Node slow=head;
        Node fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    public static void main(String args[]){
     Node head=new Node(1);
     head.next=new Node(2);
     head.next.next=new Node(3);
     head.next.next.next=new Node(4);
     head.next.next.next.next=new Node(5);
     
     reorderList(head);
     display(head);
     
    }
}
