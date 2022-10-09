import java.io.*;
import java.util.*;
public class CustomQueue
{
   private static final int DEFAULT_SIZE=10;
   protected int[] data;
   int end=-1;
   
   public CustomQueue()
   {
       this(DEFAULT_SIZE);
   }
   public CustomQueue(int size)
   {
       this.data=new int[size];
   }
   public boolean isFull()
   {
       return end==data.length-1; 
   }
   public boolean isEmpty()
   {
       return end==-1;
   }
   public boolean offer(int item) throws QueueException
   {
       if(isFull())
       {
           throw new QueueException("Capacity is full ");
       }
       data[++end]=item;
       return true;
   }
   public int poll()throws QueueException
   {
       if(isEmpty())
       {
           throw new QueueException("Cannot pop from empty queue");
       }
       int removed=data[0];
       for(int i=1;i<=end;i++)
       {
           data[i-1]=data[i];
       }
       end--;
       return removed;
   }
   public int front()throws QueueException
   {
     if(isEmpty())
     {
         throw new QueueException("Cannot peek from empty queue");
     }
     return data[end];
   }
}