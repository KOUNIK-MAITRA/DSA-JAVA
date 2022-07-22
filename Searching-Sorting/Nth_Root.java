import java.io.*;
import java.util.*;
 class Nth_Root
{
   static double pow(double num, int x){
       double product=1;
       for(int i=1;i<=x;i++)
       { product=product*num;
        }
       return product; 
    }
   
   static double nth_root(int num,int x){
       double epsilon=1e-6;
       double low=1;double high=num;
       while((high-low)>epsilon){
        double mid=(low+high)/2.0;
        if(pow(mid,x)==num){
            return mid;
        }
        else if(pow(mid,x)<num){
         low=mid;
        }
        else{
            high=mid;
        }
        }
       return low;
    }
    
   public static void main(String args[]){
     int n=25; int x=2;
     System.out.println(nth_root(n,x));
    }
}
