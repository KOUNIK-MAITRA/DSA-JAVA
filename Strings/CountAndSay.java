import java.io.*;
import java.util.*;
class CountAndSay 
{
    static String countAndSay(int n) 
    {        
        String s="1";// we start with "1"
        
        for(int i=1;i<n;i++)//we update our string s for n-1 times
        {
            s=generateString(s);
        }
        return s;
    }
    
    static String generateString(String s)
    {
        StringBuilder sb=new StringBuilder();
        char prev=s.charAt(0);//stores the character at the previous index
        int count=1;// stores count of each digit
        
        for(int i=1;i<s.length();i++)//we start from index 1
        {
            // if the curr digit is same as the prev digit
            // just update the count
            if(s.charAt(i)==prev)
            {
                count++;
            }
            // we have encountered a new digit
            // so we add the count and the prev digit to out ans string and reset count to 1
            // and our curr character becomes the prev
            else
            {
                sb.append(count);
                sb.append(prev);
                prev=s.charAt(i);
                count=1;
            }
        }
        
        // when we come out of the loop
        // count has the freq of the last digit
        // prev has the last digit of our string
        // we add them to our ans string
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
    
    public static void main(String args[])
    {
        int n=4;
        System.out.println(countAndSay(n));
    }
}