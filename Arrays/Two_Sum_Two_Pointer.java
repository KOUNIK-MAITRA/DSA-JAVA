import java.io.*;
import java.util.*;
class Two_Sum_Two_Pointer
{ 
    static ArrayList<Integer> TwoSum(int a[],int sum)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        Arrays.sort(a);
        int low=0;
        int high=a.length-1;
        for(int i=0;i<a.length;i++)
        {  int curr_sum=a[low]+a[high];
            if(curr_sum==sum)
            {ans.add(a[low]);
             ans.add(a[high]);
             }
             if(curr_sum>sum)
             high--;
             else 
             low++;
        }
         return ans;
    }
    public static void main(String args[])
    { int a[] ={2,7,11,15};   
       System.out.println(TwoSum(a,9));
   }
}