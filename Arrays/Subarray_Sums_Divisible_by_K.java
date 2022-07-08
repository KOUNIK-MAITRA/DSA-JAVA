import java.io.*;
import java.util.*;
class Subarray_Sums_Divisible_by_K
{
    public static void main (String args[])
    {
        int nums[]={4,5,0,-2,-3,1};
        int k=5;
        System.out.println(subarraysDivByK(nums,k));
    }
     static int subarraysDivByK(int[] nums, int k) {
        
        HashMap <Integer,Integer> map=new HashMap<>();
        int ans=0,sum=0,rem=0;
        map.put(0,1);
        
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            
            rem=sum%k;
            
            if(rem<0)
                rem=rem+k;
            
            if(map.containsKey(rem))
            {
                ans+=map.get(rem);
                map.put(rem,map.get(rem)+1);
            }
            else
                map.put(rem,1);
        }
        
        return ans;
        
    }
}