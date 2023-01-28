import java.io.*;
import java.util.*;
class NonDecreasingSubsequence{
    static List<List<Integer>> findSubsequences(int[] nums)
    {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        helper(list,0,nums,res);
        return res;
    }

    static void helper(List<Integer> list, int index, int[] nums,List<List<Integer>> res)
    {
        if(list.size()>1){
            res.add(new ArrayList<Integer>(list));
        }
        HashSet<Integer> used = new HashSet<>();
        for(int i=index;i<nums.length;i++)
        {
            if(used.contains(nums[i]))
                continue;
            if(list.size()==0||nums[i]>=list.get(list.size()-1)){
                used.add(nums[i]);
                list.add(nums[i]);
                helper(list,index+1,nums,res);
                list.remove(list.size()-1);
            } 
        }

    }

    public static void main(String args[])
    {
        int  nums[]={4,6,7,7};
        System.out.println(findSubsequences(nums));
    }
}