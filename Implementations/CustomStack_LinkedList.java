import java.io.*;
import java.util.*;
public class CustomStack_LinkedList
{  
   Node head;
   int size=0;
   public  CustomStack_LinkedList()
   {
       this.head=null;
       this.size=0;
   }
   public boolean isEmpty()
   {
       return head==null;
   }
   public boolean push(int item)
   {
       Node temp=new Node(item);
       temp.next=head;
       head=temp;
       size++;
       return true;
   }
   public int peek()throws StackException
   {
       if(isEmpty())
       {
           throw new StackException("Cannot peek from an empty Stack");
       }
       return head.data;
   }
   public int pop()throws StackException
   {
       if(isEmpty())
       {
           throw new StackException(" Cannot pop frm empty stack");
       }
       int top=head.data;
       head=head.next;
       size--;
       return top;
   }
   private class Node
   {
       int data;
       Node next;
       Node(int data)
       {
           this.data=data;
           next=null;
       }
   }
}
