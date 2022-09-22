import java.io.*;
import java.util.*;
 class Sort_nearly_sorted_Array
{  
   public static void main(String args[])
   {
     int n = 7, k = 3;
     int arr[] = {6,5,3,2,8,10,9};
     System.out.println(nearlySorted(arr,n,k));
   }
   static ArrayList <Integer> nearlySorted(int arr[], int num, int k)
   { 
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<=k;i++)
            minHeap.offer(arr[i]);
        
        for(int i=k+1;i<num;i++)
        {
            ans.add(minHeap.poll());
            minHeap.offer(arr[i]);
        }
        
        while(!minHeap.isEmpty())
            ans.add(minHeap.poll());
        
        return ans;    
            
   }
}

