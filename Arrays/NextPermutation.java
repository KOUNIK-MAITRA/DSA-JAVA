 // find the index_1 such that a[index_1]<a[index_1+1]//
// find index_2 such that a[index_2]>a[index_1] search from the end//  
// swap (a[index_1] ,a[index_2]) //
// reverse (index+1 --> last)//
import java.io.*;
import java.util.*;
class NextPermutation
{ 
    static void reverse (int a[], int ini ,int fin)
    { while (ini<fin)
        { swap(a,ini++,fin--);
        }
    }
    static void swap(int a[],int i,int j)
    { int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    static void display(int a[])
    { for(int ele : a)
        {System.out.print(ele+" ");}
    }
    static void Nextpermutation(int a[])
    { if(a==null||a.length<=1)
        return ;
        int i=a.length-2; // start from the second last element cause that can be the break point
        while (i>=0 && a[i]>=a[i+1])
          i--;
        
          if(i>=0) // if and only if we find a break point i.e our ind_1
          { // we search for ind_2
             int j=a.length-1; // again start from the end 
             while (a[j]<=a[i]) 
                j--;
                
                swap(a,i,j);
            }
            
            reverse (a,i+1,a.length-1);   // reverse 
        
        
    }
   public static void main(String args[])
   { int a[]={1,2,3};
       Nextpermutation(a);
      display(a);
    }
}