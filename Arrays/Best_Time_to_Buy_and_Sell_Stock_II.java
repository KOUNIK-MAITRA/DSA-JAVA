import java.io.*;
import java.util.*;
class Best_Time_to_Buy_and_Sell_Stock_II
 {
        static int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1])
                profit+=prices[i]-prices[i-1];
        }
        return profit;
        
    }
     
     public static void main ()
     { int a[]={7,5,3,6,4,2,4};
       System.out.println(maxProfit(a));
        }
}