import java.io.*;
import java.util.*;
 class CombinationSum_II{
    public static void main(String args[])
    {
     int candidates[]={2,4,3,6,7};
     int target=7;
     System.out.println(combinationSum2(candidates,target));
    }
    
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
       int n=candidates.length;
       Arrays.sort(candidates); //sort the elements
       List<List<Integer>> ans= new ArrayList<>();
       findCombinationSum(0,target,candidates,n,ans,new ArrayList<Integer>());
       return ans;  
    }
      
    static void findCombinationSum(int index,int target,int candidates[],int n,
                                   List<List<Integer>> ans,List<Integer> res )
    {   // if we reach the target then include the elements in res to our ans
        if(target==0){
            ans.add(new ArrayList<>(res));
            return; 
        }
        // check for every element in the array deom index to n-1
        for(int i=index;i<n;i++){
          //ignore duplicates  
          if(i>index && candidates[i]==candidates[i-1]) continue;
          // if the ele is greater than target itself ignore this subsequence
          // as the array is sorted the folllowing elements will also be greater
          if(candidates[i]>target) break; 
          //else 
          // this ele might be a part of our potentil answer so add it to res
          res.add(candidates[i]);
          findCombinationSum(i+1,target-candidates[i],candidates,n,ans,res);
          res.remove(res.size()-1);  
        }
    }
}

