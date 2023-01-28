// merge two sorted arrays and dont use any extra space //

import java.io.*;
import java.util.*;
class Merge_Two_Sorted_Arrays
{
    static void merge (int a[],int b[])
    { 
        int m=a.length;
        int n=b.length;

        for(int i=0;i<m;i++)
        { if (a[i]>b[0])
            { int temp=a[i];
                a[i]=b[0];
                b[0]=temp;

                int first=b[0];
                int k;
                for ( k=1;k<n && b[k]<first;k++) // sorting the second  array back in order
                { b[k-1]=b[k];
                }
                b[k-1]=first;
            }
        }
    }

    public static void main(String args[])
    { 
        int a[]={1,4,7,8,10};
        int b[]={2,3,9};

        merge(a,b);

        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");

        for(int i=0;i<b.length;i++)
            System.out.print(b[i]+" ");

    }
}