import java.io.*;
import java.util.*;
 class CombinationSum
{
    public static void main(String args[])
    {
     int candidates[]={2,3,6,7};
     int target=7;
     System.out.println(combinationSum(candidates,target));
    }
    
    static List<List<Integer>> combinationSum(int[] candidates, int target) 
     {
       int n=candidates.length;
       List<List<Integer>> ans= new ArrayList<>();
       findCombinationSum(0,target,candidates,n,ans,new ArrayList<Integer>());
       return ans; 
       }
    
    static void findCombinationSum(int index,int target,int candidates[],int n,
                                   List<List<Integer>> ans,List<Integer> res )
    {  
      if(index==n) // we have no more elements to choose from
       { 
          if(target==0) // we have reached our target so we add the elements we picked stored in res to our ans
            ans.add(new ArrayList<>(res));
          return ;
        }
      // we pick elements that are less than or equal to our target , if ele> target it cannot contribute to our ans  
        if(candidates[index]<=target){
            res.add(candidates[index]); // we add this ele to our res
            // duplicates are allowed so we start again from index
            findCombinationSum(index,target-candidates[index],candidates,n,ans,res); // and search again in the array for our new target i.e target-ele
            res.remove(res.size()-1);// we remove this element after the recursive call is over
        }
      // we  chose not to pick this ele hence we look for our target in the remaining array so we call the function from index+1
        findCombinationSum(index+1,target,candidates,n,ans,res);

        
     }
}
