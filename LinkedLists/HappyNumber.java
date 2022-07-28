import java.io.*;
import java.util.*;
class HappyNumber
{
   static boolean isHappy(int n) {
       int slow=n;
       int fast=n;
        
        do{
            slow=sumOfSquares(slow);
            fast=sumOfSquares(sumOfSquares(fast));
        }
        while(slow!=fast);
        
        if(fast==1)
            return true;
        else
            return false;
    }
    
   static int sumOfSquares(int n)
    {
        int sum=0;
        while(n>0)
        {
            int rem=n%10;
            sum+=(rem*rem);
            n=n/10;
        }
        return sum;
    }  
   public static void main(String args[])
    {
        int n=19;
        System.out.println(isHappy(n));
    }
}
