import java.io.*;
import java.util.*;
class Number_Of_Subsets_with_sum_Target_Recursion
{
    public static void main(String args[]){
        int nums[]={1, 2, 2, 3};
        int target=3;
        System.out.println(findWays(nums,target));
    }
    static int findWays(int nums[], int target) {
        int n=nums.length;
        return countWays(nums,n-1,target);
    }
    
    static int countWays(int nums[],int index,int target){
        if(target==0)
            return 1;
        if(index==0)
        {
            if(nums[0]==target)
                return 1;
            else
                return 0;
        }
        
        int notPick=countWays(nums,index-1,target);
        int pick=0;
        if(nums[index]<=target)
           pick=countWays(nums,index-1,target-nums[index]);
        
        return pick+notPick;
    }
}
