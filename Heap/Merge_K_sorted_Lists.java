import java.io.*;
import java.util.*;
 class Merge_K_sorted_Lists
{
   static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int key)
        {   val = key;
            next = null;
        }
    }
   static ListNode mergeKLists(ListNode[] lists) {
        
        // create a mean heap so we get the node with least value
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->(a.val-b.val));
        
        // add the head of the k lists in the priority queue
        for(ListNode node:lists)
        {
            if(node!=null) pq.offer(node);
        } 
        
        if(pq.isEmpty()) return null;
        
        ListNode head=new ListNode(0);
        ListNode last=head;
        
        while(!pq.isEmpty())
        {
          ListNode curr=pq.poll();// take out the node with least val
          last.next=curr; // add it to our ans list
          last=last.next;
          
          // if curr has more nodes attached to it then add curr,next to our priority queue
          if(curr.next!=null) pq.offer(curr.next);  
        }
        
        return head.next; // return head of the merged list
    }
   public static void main(String args[])
   { ListNode head1=new ListNode(1);
     head1.next=new ListNode(3);
     
     ListNode head2=new ListNode(4);
     head2.next=new ListNode(5);
     head2.next.next=new ListNode(6);
     
     ListNode head3=new ListNode(8);
     
     ListNode[] arr=new ListNode[3];
     arr[0]=head1;
     arr[1]=head2;
     arr[2]=head3;
     
     
     ListNode ans=mergeKLists(arr);
     while(ans!=null)
     {
        System.out.print(ans.val+"-->");
        ans=ans.next;    
     }
      System.out.print("null");
    }
}
