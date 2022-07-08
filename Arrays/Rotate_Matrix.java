import java.io.*;
import java.util.*;
class Rotate_Matrix
{
    static void reverse(int a[])
    { int left=0; int right=a.length-1;
        for(int i=left;i<a.length/2;i++)
        { int temp=a[i];
            a[i]=a[right-i];
            a[right-i]=temp;
        }
    }
   static void rotate( int a[][],int rows, int cols)
    { for (int i=0;i<rows;i++)
        { for(int j=0;j<i;j++) // imp line for transpose
            { 
                int temp=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
        }
         for(int i=0;i<rows;i++)
         {reverse(a[i]);
            }
    }
    static void  display(int a[][],int rows, int cols)
     { 
        for(int i=0;i<rows;i++)
        { for(int j=0;j<cols;j++)
            {System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
   { int a[][]={ {1,2,3},
                 {4,5,6},
                 {7,8,9}
               };
        int rows=a.length;
        int cols=a[0].length;
        rotate(a, rows,  cols);
         display(a,rows,cols);
         
     }
}