// kadane's algorithm //
import java.io.*;
import java.util.*;
class MaximumSubarraySum
{ 
  static int maxSum(int a[])
    { int sum=0;
        int max=a[0];
        for(int i=0;i<a.length;i++)
        { sum=sum+a[i];
            max=Math.max(sum,max);  
            if(sum<0)
             sum=0;
           
        }        
    return max;
    }
  public static void main(String args[])
    {
        int a[]={-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSum(a));
    }
}