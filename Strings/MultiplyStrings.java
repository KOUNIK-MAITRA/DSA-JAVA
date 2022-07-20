import java.io.*;
import java.util.*;
class MultiplyStrings
{
     public static void main(String args[])
      { String num1="123";
          String num2="456";
         System.out.println(multiply(num1,num2)); 
        }
      static String multiply(String num1, String num2) {
     
        if(num1.equals("0")||num2.equals("0"))
        { return "0";}
     
        if(num1.equals("1"))
         return num2;   
      
        if(num2.equals("0"))
         return num1;
      
        int m=num1.length();
        int n=num2.length();
        
        int[] result=new int[m+n];
        
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
              int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');  
              int product_pos=i+j+1;  
              int carry_pos=i+j;
              
              int sum=mul+result[product_pos];
              result[product_pos]=sum%10;
              result[carry_pos]+=sum/10;  
            }
        }
        
       //remove leading 0s
        
        String ans="";
       int pos_of_first_NonZero_Element=0;
       for(int i=0;i<result.length;i++)
       {
           if(result[i]!=0)
           {
              pos_of_first_NonZero_Element=i;
               break;
           }
       }
       
       for(int i=pos_of_first_NonZero_Element;i<result.length;i++) 
       {
           ans=ans+result[i];
       }
        
        return  ans;
    }
}
