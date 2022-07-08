// in an array of size n and with numbers from 1 to n find the number which is duplicate assuming there is only one such element//
import java.io.*;
import java.util.*;
class Find_Duplicate
{   
    static int duplicate(int a[])
    { int slow=a[0];
        int fast=a[0];
        do
        {slow=a[slow];
         fast=a[a[fast]];
        }
        while(slow!=fast);
        
        fast=a[0];
        while(slow!=fast)
        {slow=a[slow];
            fast=a[fast];
        }
        return slow;
    }
    public static void main (String args[])
    {int a[]={2,5,6,9,3,8,9,7,1,4}; 
       System.out.println(duplicate(a));
      }
}