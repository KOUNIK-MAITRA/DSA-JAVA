import java.io.*;
import java.util.*; 
class QueueMain
{
    public static void main(String args[])throws QueueException
    {
        CustomQueue queue=new CustomQueue(5);
        try
        {
            queue.offer(1);
            queue.offer(2);
            queue.offer(3);
            queue.offer(4);
            queue.offer(5);
            
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue.poll());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
