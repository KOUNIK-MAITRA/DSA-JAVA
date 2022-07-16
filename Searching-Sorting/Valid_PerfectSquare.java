import java.io.*;
import java.util.*;
 class Valid_PerfectSquare
{
  public static void main(String args[])
  { int num =25;
      System.out.println(isPerfectSquare(num));
    }
  static boolean isPerfectSquare(int num) {
     return binarySearchSqrt(num);
    }
  static boolean binarySearchSqrt(int x)
    {
        if(x==0)
         return true;
         
        long low=1;
        long high=x;
     
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            
            
            if(mid*mid== x)
                return true;
            if(mid*mid<x)
            {
                
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }  
}
