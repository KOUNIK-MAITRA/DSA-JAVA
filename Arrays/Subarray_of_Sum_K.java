import java.io.*;
import java.util.*;
 class Subarray_of_Sum_K
{
   public static void main (String args[])
   {
       int nums[]={1,2,3};
       int k=3;
       System.out.println(subarraySum(nums,k));
    }
     static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int curr_sum=0;
      
        int count=0;
        
         for (int i=0;i<nums.length;i++)
        {
             curr_sum=curr_sum+nums[i];
            if (curr_sum==k)
             count++;
            if(map.containsKey(curr_sum-k))
               count+=map.get(curr_sum-k); 
              map.put(curr_sum,map.getOrDefault(curr_sum,0)+1);
     }
        return count;
   }
}
