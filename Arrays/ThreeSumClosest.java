import java.io.*;
import java.util.*;
 class ThreeSumClosest
{
  public static void main(String args[])
  {
   int nums[]={-1,2,1,-4};
   int target=1;
   System.out.println(threeSumClosest(nums,target));
  }
  static int threeSumClosest(int[] nums, int target) 
    {   
        int n=nums.length;
        Arrays.sort(nums);
        // we will consider the first 3 numbers are closest to our target
        int sum=nums[0]+nums[1]+nums[2];
        //3 sum approach
        for(int i=0;i<n-2;i++)
        { 
            int low=i+1;
            int high=n-1;
            
            while(low<high)
            {
                int temp=nums[i]+nums[low]+nums[high];
                
                // if diff between temp and target is less than sum and target
                //then temp can be a possible ans so we update the sum
                if(Math.abs(temp-target) < Math.abs(sum-target) ) 
                sum=temp;
                
                if(temp>target) high--;                  
                
                else if(temp<target) low++;            
                
                else return target;
            }
            
        }
        return sum;
    }
}
