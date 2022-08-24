import java.io.*;
import java.util.*;
class Permuations_Approach_1
{
  public static void main(String args[]){
      int nums[]={1,2,3};
      System.out.println(permute(nums));
   }
  static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean check[]=new boolean[nums.length];
        ArrayList<Integer> res= new ArrayList<>();
        permutations(nums,ans,res,check);
        return ans;
    }
  static void permutations(int nums[],List<List<Integer>> ans,ArrayList<Integer> res,boolean check[])
    {
      if(res.size()==nums.length) // if res contains the same no.of elements as our nums array then we have succesfully made a permuattion
      { ans.add(new ArrayList<>(res));// so we add it to our list
        return;
      }
      // iterate through th nums array and pick an element that has not neen picked before  
      for(int i=0;i<nums.length;i++){
          if(!check[i]){
              res.add(nums[i]);// add it to the res
              check[i]=true;// since it has been picked mark it true
              permutations(nums,ans,res,check);// recursive call for the remaining digits in this permutation
              res.remove(res.size()-1);// after the call is over remove the last added element cause we will be backtracking
              check[i]=false;// and mark it again as non picked
          }
      }  
    }  
}
