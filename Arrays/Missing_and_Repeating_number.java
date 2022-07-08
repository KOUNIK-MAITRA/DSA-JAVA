import java.io.*;
import java.util.*;
 class Missing_and_Repeating_number
{
    static List<Integer> repeat_missing(int a[])
    {  List<Integer> ans=new ArrayList<>();
        int n=a.length;
        int x,y;
        int sum=0 ,sum_sq=0;
        for(int i=0;i<a.length;i++)
        { sum=sum+a[i]; // sum of the array elements
            sum_sq+=a[i]*a[i]; // sum of the square of the array ellements
        }
        
        int natural_sum=n*(n+1)/2; // sum of the first n natural numbers
        int natural_sumsq=n*(n+1)*(2*n+1)/6; // sum of squares of first n natural numbers
        
        int eq1=sum-natural_sum; // X-Y=eq1
        int eq2=sum_sq-natural_sumsq; // X^2 -Y^2=eq2
        // (X+Y)(X-Y)=eq2
        // X+Y=eq2/eq1--->Eq
        // X-Y=eq1
        // X=eq1+Y
        // X+Y=Eq --> eq1+Y+Y=Eq ---> eq1+2Y=Eq ---> Y=(Eq-eq1)/2
        int Eq=eq2/eq1;
        y=(Eq-eq1)/2; // find the missing number 
        x=eq1+y; // find the repeating number 
        
        ans.add(y);
        ans.add(x);
        return ans;
    }
   
    public static void main (String args[])
   {  int a[]={4,3,2,6,1,1};
     List<Integer> soln=new ArrayList<>();
     soln=repeat_missing(a);
     for(int ele: soln)
     System.out.print(ele+" ");
    }
}
