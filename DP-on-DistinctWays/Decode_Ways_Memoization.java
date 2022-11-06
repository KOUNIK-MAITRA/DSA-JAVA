import java.io.*;
import java.util.*;
class Decode_Ways_Memoization
{
    static int numDecodings(String s) {  
        int n=s.length();
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return countWays(0,s,dp);  
    }

    static int countWays (int index,String s,int dp[]){

        if(index>=s.length()) 
            return 1;

        if(s.charAt(index)=='0')
            return 0;

        if(dp[index]!=-1)
            return dp[index];

        int takeOneDigit = countWays(index+1,s,dp);
        int takeTwoDigits=0;

        if(index<=s.length()-2)
        {
            //generate the 2 digit number
            StringBuilder sb=new StringBuilder();
            sb.append(s.charAt(index));
            sb.append(s.charAt(index+1));
            int num = Integer.parseInt(sb.toString());

            if(num<=26)
                takeTwoDigits=countWays(index+2,s,dp); 

        }

        return dp[index]=takeOneDigit+takeTwoDigits;
    }

    public static void main(String args[])
    {
        String s="226";
        System.out.println(numDecodings(s));
    }
}
