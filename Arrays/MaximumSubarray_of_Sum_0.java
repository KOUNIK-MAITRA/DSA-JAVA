import java.io.*;
import java.util.*;
 class MaximumSubarray_of_Sum_0
{
    static int largestSubarray(int nums[])
    { int max_len=0;
        if(nums==null || nums.length==0)
         return max_len;
      HashMap<Integer,Integer> map=new HashMap<>();
      int curr_sum=0;
      for(int i=0;i<nums.length;i++)
       { curr_sum+=nums[i];
           if(curr_sum==0)
           { max_len=i+1;
            }
            else
            { if(map.get(curr_sum)!=null)
                { max_len=Math.max(max_len,i-map.get(curr_sum));
                }
                else
                { map.put(curr_sum,i);
                }
            }
        }
      
        return max_len;
    }
    public static void main (String args[])
    { int nums[]={15,-2,2,-8,1,7,10,23};
      System.out.println(largestSubarray(nums));
    }
}
