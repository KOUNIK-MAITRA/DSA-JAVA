import java.io.*;
import java.util.*;
 class Subsets
{
  public static void main(String args[]){
    int nums[]={1,2,3};
    System.out.println(subsets(nums));
  }
  static List<List<Integer>> subsets(int[] nums) {
        int n=nums.length; 
        List<List<Integer>> ans= new ArrayList<>();
        allSubsets(0,nums,n,ans,new ArrayList<Integer>());
        return ans;
    }
    
  static void allSubsets(int index, int nums[], int n,List<List<Integer>> ans,ArrayList<Integer> res)
   {  if(index==n){
            ans.add(new ArrayList<>(res));
            return;
        }
            
        res.add(nums[index]);
        allSubsets(index+1,nums,n,ans,res);
        res.remove(res.size()-1);
    
        allSubsets(index+1,nums,n,ans,res);
        
       
    }
}
