import java.io.*;
import java.util.*;
 class Find_All_Duplicates
{
   public static void main (String args[])
   {
       int nums[]={4,3,2,7,8,2,3,1};
       System.out.println(findDuplicates(nums));
    }
     static List<Integer> findDuplicates(int[] nums) {
        
        List <Integer> ans= new ArrayList<>();
           int i=0;    
        while(i<nums.length)
        {
            int correctIndex=nums[i]-1;
            if(nums[correctIndex]!=nums[i])
            {
                int temp=nums[correctIndex];
                nums[correctIndex]=nums[i];
                nums[i]=temp;
            }
            else
            {
                i++;
            }
        }
        
        for(int ind=0;ind<nums.length;ind++)
        {
            if(nums[ind]!=ind+1)
                ans.add(nums[ind]);
        }
        
        return ans;
    }
}
