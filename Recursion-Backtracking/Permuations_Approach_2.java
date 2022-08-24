import java.io.*;
import java.util.*;
class Permuations_Approach_2
{
  public static void main(String args[]){
      int nums[]={1,2,3};
      System.out.println(permute(nums));
   }
 
  static List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ans= new ArrayList<>();
       permutations(0,nums,ans);
       return ans; 
    }
    
  static void permutations(int index,int []nums,List<List<Integer>> ans){
        if(index==nums.length) //if we have crossed the last index that means we have made a valid permutation so we add it to our and list
        {   List<Integer> res= new ArrayList<>();
            for(int ele : nums)
             res.add(ele);
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            swap(index,i,nums);
            permutations(index+1,nums,ans);
            swap(index,i,nums);
        }
        
    }
    
  static void swap(int a, int b, int nums[]){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}

