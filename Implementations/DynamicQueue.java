import java.io.*;
import java.util.*;
class DynamicQueue extends CircularQueue
{
   public DynamicQueue()
   {
     super();
   }
   public DynamicQueue(int size)
   {
     super(size);
   }
   @Override
   public boolean insert(int item) throws QueueException
   {
       if(isFull())
       {
           int[] temp=new int[2*data.length];
           for(int i=0;i<data.length;i++)
           {
               temp[i]=data[front+i];
           }
           front=front%data.length;
           end=data.length;
           data=temp;
       }
       return super.insert(item);
   } 
}
