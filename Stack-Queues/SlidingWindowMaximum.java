import java.io.*;
import java.util.*;
 class SlidingWindowMaximum
{
  public static void main(String args[]){
    int nums[]={1,3,-1,-3,5,3,6,7};
    int k=3;
    System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
   static int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
     int []ans=new int[n-k+1];// no of possible subarrays of size k
        int x=0;
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        int i=0;
        
        //for first k elements
        
        for(;i<k;i++){
            //add indexes to the deque
            //maintain the deque in a decreasing fashion
            // the front element will always be the max of the curr window
            // add elements at the last
            // while adding if the ele to be added is greater than the last element of the deque
            // remove the elemnts to maintain the decreasing fashion
            
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()])
                deque.removeLast();
            
            deque.addLast(i);
        }
        
        //for the remaining elements 
        
        for(;i<nums.length;i++)
        {
            // add the max element for the curr subarray of size k
            ans[x++]=nums[deque.peek()];
            
            //remove elements that are not in the curr window
            // the window range should be i-k+1 to i
            
            while(!deque.isEmpty() && deque.peek()<=i-k)
             deque.removeFirst();
            
             //add indexes to the deque
            //maintain the deque in a decreasing fashion
            // the front element will always be the max of the curr window
            // add elements at the last
            // while adding if the ele to be added is greater than the last element of the deque
            // remove the elemnts to maintain the decreasing fashion
            
            
              while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()])
                deque.removeLast();
            
            deque.addLast(i);
        }
         ans[x++]=nums[deque.peek()]; // add the max element for the last window
       return ans; 
    } 
}
