import java.io.*;
 class SquareRoot
{
   public static void main (String args[])
   { int x=25;
     System.out.println(mySqrt(x));
    }
     static int binarySearchSqrt(int x)
    {
        if(x==0)
            return 0;
        int low=1;
        int high=x;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            
            if(mid==x/mid)
                return mid;
            if(mid<x/mid)
            {
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    static int mySqrt(int x) {
        return binarySearchSqrt(x);
    }
}
