import java.io.*;
import java.util.*;
class Decode_Ways_Recursion
{
    static int numDecodings(String s) {  
        int n=s.length();
        return countWays(0,s);  
    }

    static int countWays (int index,String s){

        if(index>=s.length()) 
            return 1;

        if(s.charAt(index)=='0')
            return 0;

        int takeOneDigit = countWays(index+1,s);
        int takeTwoDigits=0;

        if(index<=s.length()-2)
        {
            //generate the 2 digit number
            StringBuilder sb=new StringBuilder();
            sb.append(s.charAt(index));
            sb.append(s.charAt(index+1));
            int num = Integer.parseInt(sb.toString());

            if(num<=26)
                takeTwoDigits=countWays(index+2,s); 

        }

        return takeOneDigit+takeTwoDigits;
    }

    public static void main(String args[])
    {
        String s="226";
        System.out.println(numDecodings(s));
    }
}
