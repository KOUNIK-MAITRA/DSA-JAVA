import java.io.*;
import java.util.*;
class Seive
{
 public static void main(String args[])
   {
       int n=40;
       printPrimes(n);
   }
   static void printPrimes(int n)
   {
        boolean primes[]=new boolean[n+1];
        Arrays.fill(primes,true);
        for(int i=2;i*i<=n;i++)
        {
            if(primes[i])// if a number is prime mark all its multiple false
            {
                for(int j=i*2;j<=n;j+=i)
                {
                    primes[j]=false;
                }
            }
        }
        for(int i=2;i<=n;i++)
        {
            if(primes[i])
                System.out.print(i+" ");
        }
 }
}
