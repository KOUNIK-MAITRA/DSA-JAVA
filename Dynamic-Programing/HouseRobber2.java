import java.io.*;
import java.util.*;
class HouseRobber2
{
    public static void main(String args[])
    {
        int nums[]={1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int maxNonAdjacent(int nums[],int n)
    {
        
       int prev=nums[0];
       int prev2=0;
        for(int i=1;i<n;i++)
        {
          int pick=nums[i];
            if(i>1)
                pick+=prev2;
          int notpick=0+prev;
            
          int curr=Math.max(pick,notpick);  
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    
    public static int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int temp_1[]=new int[nums.length-1];
        int temp_2[]=new int[nums.length-1];
        
        int x=0,y=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(i!=nums.length-1)
                temp_1[x++]=nums[i];
            if(i!=0)
                temp_2[y++]=nums[i];
        }
        
        return Math.max(maxNonAdjacent(temp_1,nums.length-1),maxNonAdjacent(temp_2,nums.length-1));
    }
    
}