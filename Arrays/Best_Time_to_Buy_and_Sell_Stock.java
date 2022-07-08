import java.io.*;
import java.util.*;
class Best_Time_to_Buy_and_Sell_Stock
 {
     static int max_Profit(int a[])
     { int max_profit=0;
         int minPrice=99999;
         for(int i=0;i<a.length;i++)
         { minPrice=Math.min(minPrice,a[i]);
             max_profit=Math.max(max_profit,a[i]-minPrice);
            }
            return max_profit;
        }
     
     public static void main ()
     { int a[]={7,5,3,6,4,2,4};
       System.out.println(max_Profit(a));
        }
}