import java.io.*;
import java.util.*;
 class PrintingSubsequences_with_Sum_K
{
  public static void main(String args[]){
   int nums[]={1,2,3,4,5}; int n=nums.length; int k=8;
   ArrayList<Integer> res= new ArrayList<Integer>();
   subsequencesWithSum_K(0,nums,n,0,k,res);
    }
  static void subsequencesWithSum_K(int index,int nums[], int n,int sum ,int target, ArrayList<Integer> res){
   if(index==n){
    if(sum==target)
     System.out.println(res);
    return;
    }  
   // if we donot take nums[index] in our subsequence 
   subsequencesWithSum_K(index+1,nums,n,sum,target,res);
   // if we take the number nums[index] in our subsequence
   if(sum+nums[index]<=target){
       res.add(nums[index]); sum+=nums[index];
       subsequencesWithSum_K(index+1,nums,n,sum,target,res);
       res.remove(res.size()-1);sum-=nums[index];
   }
  }
}
