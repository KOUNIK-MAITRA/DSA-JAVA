import java.io.*;
import java.util.*;
public class CircularQueue
{
    protected int data[];
    public static final int DEFAULT_SIZE=10;
   
    protected int front=0;
    protected int end=0;
    private int size=0;
    public CircularQueue()
    {
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size)
    {
      data=new int[size];
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public boolean isFull()
    { 
        return size==data.length;
    }
    public boolean insert (int item) throws QueueException
    {
      if(isFull())
      {
          throw new QueueException("Queue is already full");
      }
      data[end++]=item;
      end=end%data.length;
      size++;
      return true;
    }
    public int delete()throws QueueException
    {
        if(isEmpty())
        {
            throw new QueueException("Cannot delete element from empty Queue");
        }
        int deleted= data[front++];
        front=front%data.length;
        size--;
        return deleted;
    }
    public int front()throws QueueException
    {
         if(isEmpty())
        {
            throw new QueueException("Queue is Empty");
        }
        return data[front];
    }
    public int end()throws QueueException
    {
         if(isEmpty())
        {
            throw new QueueException("Queue is Empty");
        }
        return data[end];
    }
}
