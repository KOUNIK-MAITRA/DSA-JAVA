import java.io.*;
import java.util.*;
class Number_Of_Subsets_with_sum_Target_SpaceOptimized
{
    public static void main(String args[]){
        int nums[]={12,1,3};
        int target=4;
        System.out.println(countWays(nums,nums.length,target));
    }
   
    static int countWays(int nums[],int n,int target){
      int prev[]=new int[target+1];
      int curr[]=new int[target+1];
      for(int i=0;i<n;i++){
        prev[0]=1;
        }
        
      if(nums[0]<=target){
         prev[nums[0]]=1;
        }
        
      for(int index=1;index<n;index++){
       for(int currTarget=1;currTarget<=target;currTarget++){
          int notPick=prev[currTarget];
          int pick=0;
          if(nums[index]<=currTarget)
          { pick=prev[currTarget-nums[index]];
            }
          
          curr[currTarget]=pick+notPick;
        }
        prev=curr;
        }
      return prev[target];
    }
}
