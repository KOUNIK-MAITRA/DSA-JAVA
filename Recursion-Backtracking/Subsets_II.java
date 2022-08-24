import java.io.*;
import java.util.*;
 class Subsets_II
{
  public static void main(String args[]){
    int nums[]={1,2,2};
    System.out.println(subsetsWithDup(nums));
  }
     static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subsets(0,nums,ans,new ArrayList<>());
        return ans;
    }
    
    static void subsets(int index,int nums[],List<List<Integer>> ans,List<Integer>res)
    {
        ans.add(new ArrayList<>(res));
        for(int i=index;i<nums.length;i++) {
            if(i>index && nums[i]==nums[i-1]) continue;
            res.add(nums[i]);
            subsets(i+1,nums,ans,res);     
            res.remove(res.size()-1);
        }
    }
}
