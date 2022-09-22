import java.io.*;
import java.util.*;
 class HandOfStraights
{
  public static void main(String args[])
  {
      int []hand={1,2,3,6,2,3,4,7,8}; int groupSize=3;
      System.out.println(isStraightHand(hand,groupSize));
  }
  static boolean isStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(); //minHeap
        for(int card : hand)
            pq.offer(card);
        
        while(!pq.isEmpty())
        {
            int startCard=pq.poll();
            for(int i=1;i<groupSize;i++)
            {
                if(pq.remove(startCard+i))
                 continue;
                else 
                 return false; // the next consequtive card is not present
            }
        }
        return true;
    }
}
