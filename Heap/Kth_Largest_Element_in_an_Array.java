import java.io.*;
import java.util.*;
 class Kth_Largest_Element_in_an_Array
{
    public static void main(String args[]){
      int[]nums = {3,2,1,5,6,4};
      int k = 2;
      System.out.println("Kth-Largest Element is "+findKthLargest(nums,k));
    }
     static int findKthLargest(int[] nums, int k) {
      //make a priority queue of size K
      // make sure only K largest elements are present in the queue
      // since it is a min heap
      // the Kth largest element will be the smallest among the K largest elements
      // hence it will be at the top of the heap
     PriorityQueue<Integer> pq=new PriorityQueue<>();
     for(int i =0;i<k;i++) // insert the first k elements
      pq.add(nums[i]);
   
        for(int i=k;i<nums.length;i++) // for rest of the elements
        {
            if(pq.peek()<nums[i]) // if the element is greater than the top of the heap
            { pq.poll(); // remove the topmost element
             pq.add(nums[i]); // add the curr element
             }
            
      }
        return pq.peek(); // top of the priority queue will have the answer
    }
}
