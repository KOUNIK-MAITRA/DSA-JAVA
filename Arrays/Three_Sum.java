import java.io.*;
import java.util.*;
 class Three_Sum
{
   public static void main (String args[])
    {
        int nums[]={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    static List<List<Integer>> threeSum(int[] nums) {
       
       Arrays.sort(nums);

       int n = nums.length;
    
      List<List<Integer>> res = new ArrayList<>();
    
     for(int i =0;i<n-2;i++)
     {
        if(i == 0 || (i> 0 && nums[i] != nums[i-1]))
        {
            int sum = -nums[i];
            int low = i + 1;
            int high = n-1;
            
            while(low < high)
            {
                if((nums[low] + nums[high]) == sum)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    
                    res.add(temp);
                    
                    low++;
                    high--;
                    
                    while(low < high && nums[low] == nums[low-1]) 
                     low++;
                    while(high > low && nums[high] == nums[high+1]) 
                     high--;
                }
                else if((nums[low] + nums[high]) > sum)
                {
                    high--;
                }
                else if((nums[low] +nums[high]) < sum)
                {
                    low++;
                }
            }
        }
    }
     return res;
    }
}
