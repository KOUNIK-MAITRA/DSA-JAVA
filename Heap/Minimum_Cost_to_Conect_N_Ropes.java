import java.io.*;
import java.util.*;
 class Minimum_Cost_to_Conect_N_Ropes
{
   public static void main(String args[])
   {int n = 4;
    long arr[] = {4, 3, 2, 6};
    System.out.println(minCost(arr,n) );
    }
   static long minCost(long arr[], int n) 
    {
       long cost=0;
       PriorityQueue<Long> pq=new PriorityQueue<>();
       for(long ele :arr)
        pq.add(ele);
        
        while (pq.size()>=2){
            long first=pq.poll();
            long second=pq.poll();
            
            long lengthOfNewRope=first+second;
            cost+=lengthOfNewRope;
            pq.add(lengthOfNewRope);
        }
        
        return cost;
    }
}
