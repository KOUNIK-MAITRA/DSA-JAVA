import java.io.*;
import java.util.*;
 class Count_Subsequences_with_Sum_K
{
  public static void main(String args[]){
   int nums[]={1,2,3,4,5}; int n=nums.length; int k=8;
   System.out.println(subsequencesWithSum_K(0,nums,n,0,k));
    }
  static int subsequencesWithSum_K(int index,int nums[], int n,int sum ,int target){
   if(index==n)
   { if(sum==target) return 1 ;
     else return 0;   
    }
   int count =0;
   int take=0;
   if(sum+nums[index]<=target){
   sum+=nums[index];
   take=subsequencesWithSum_K(index+1,nums,n,sum,target);
   sum-=nums[index];
  } 
   int notTake=subsequencesWithSum_K(index+1,nums,n,sum,target);
   
   return take+notTake;
  }
}
