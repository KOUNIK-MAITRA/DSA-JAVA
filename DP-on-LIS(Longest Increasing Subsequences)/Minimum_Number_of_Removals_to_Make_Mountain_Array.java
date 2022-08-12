import java.io.*;
import java.util.*;
 class Minimum_Number_of_Removals_to_Make_Mountain_Array
{
 public static void main(String args[]){
   int nums[]={2,1,1,5,6,2,3,1};
   System.out.println(minimumMountainRemovals(nums));
    }
 static int minimumMountainRemovals(int[] nums) {
      int n=nums.length;
      int lengthOfLongestBitonicArray=longestBiotonicArray(nums); 
        return n-lengthOfLongestBitonicArray;
    }
    
    static int longestBiotonicArray(int []nums){
        int n=nums.length; 
     
        int dpLIS[]=new int[n];
        Arrays.fill(dpLIS,1);  
     
        int dpLIS_rev[]=new int[n]; 
        Arrays.fill(dpLIS_rev,1);  
        
        int bitonic[]=new int[n];
        
        // filling up dpLIS[]
        for(int i=1;i<n;i++){
            int curr=i;
            for(int prev_index=0;prev_index<curr;prev_index++){
              if(nums[curr]>nums[prev_index])
               dpLIS[curr]=Math.max(dpLIS[curr],1+dpLIS[prev_index]);
            }
        }
        
        
        //filling up dpLIS_reverse[]
        for(int i=n-2;i>=0;i--){
            int curr=i;
            for(int prev_index=n-1;prev_index>curr;prev_index--){
              if(nums[curr]>nums[prev_index])
               dpLIS_rev[curr]=Math.max(dpLIS_rev[curr],1+dpLIS_rev[prev_index]);
            }
        }
        
        //filling up bitonic[]
        for(int i=0;i<n;i++)
            bitonic[i]=(dpLIS[i]+dpLIS_rev[i])-1;
        
        int maxLength=0;
        for(int i=0;i<n;i++)
        { if(dpLIS[i]>1 && dpLIS_rev[i]>1)  
            maxLength=Math.max(bitonic[i],maxLength);}
        
        return maxLength;
    }  
}
