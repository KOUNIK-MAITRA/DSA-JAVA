import java.io.*;
import java.util.*;
class Valid_Triangle_Number
{
   public static void main(String args[])
   {
       int nums[]={2,2,3,4};
       System.out.println(triangleNumber(nums));
   }
   static int triangleNumber(int[] nums) {
        Arrays.sort(nums);// sort the array
        int i,j,k;
        int count=0;
        for(k=nums.length-1;k>1;k--)
        {
            i=0; j=k-1;
            while(i<j)
            {
                if(nums[i]+nums[j]>nums[k]) //valid triangle number
                {
                  //all numbers between i and j are larger than i hence the 
                  // nums[i]+nums[j]>nums[k] for all is in the range i to j
                  // total no.of pairs of i,j that make valid triangle number with k are j-i  
                  count+=j-i;   
                  j--; // now we try to find valid triangle number of a different j
                }
                else // if nums[i]+nums[j]<nums[k] then we need to increase the i
                    i++;
            }
        }
        return count;
    }
}
