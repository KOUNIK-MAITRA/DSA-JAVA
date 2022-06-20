import java.io.*;
import java.util.*;
 class GridUniquePaths_Recusion
{
    public static void main(String args[])
    {
        int m=3;
        int n=2;
        System.out.println(uniquePaths(m-1,n-1));
    }
    public static int uniquePaths(int m, int n)
    {
        if(m==0 && n==0)
         return 1;
        
        if(m<0 || n<0)
         return 0;
         
         int temp1=uniquePaths(m-1,n);
         int temp2=uniquePaths(m,n-1);
         
         return temp1+temp2;
    }
}
