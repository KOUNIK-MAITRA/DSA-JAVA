import java.io.*;
import java.util.*;
public class SquareRoot
{
    public static void main(String args[])
    {
        int n=36;
        System.out.println(sqrt(n));
    }
    static int sqrt(int n)
    {
        int low=1;
        int high=n;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(mid*mid==n) return mid;
            else if(mid*mid>n)
             high=mid-1;
            else
             low=mid+1;
        }
        return -1;
    }
}
