import java.io.*;
import java.util.*; 
class CircularQueueMain
{
    public static void main(String args[])throws QueueException
    {
        CircularQueue queue=new CircularQueue(5);
        try
        {
            queue.insert(1);
            queue.insert(2);
            queue.insert(3);
            queue.insert(4);
            queue.insert(5);
            queue.delete();
            queue.insert(6);
            
            System.out.println(queue.delete());
            System.out.println(queue.delete());
            System.out.println(queue.delete());
            System.out.println(queue.delete());
            System.out.println(queue.delete());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
