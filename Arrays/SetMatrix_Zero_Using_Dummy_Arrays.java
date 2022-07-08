import java.io.*;
import java.util.*;
class SetMatrix_Zero_Using_Dummy_Arrays
{

static void setZeroes(int a[][])
{
    int row[]=new int[a.length];
    int col[]=new int [a[0].length];
    for(int i=0;i<row.length;i++)
    row[i]=-1;
    for(int i=0;i<col.length;i++)
    col[i]=-1;
        
    for(int i=0;i<a.length;i++)
    { for(int j=0;j<a[0].length;j++)
        { if(a[i][j]==0)
            { row[i]=0;
                col[j]=0;
            }
        }
    }
    
    for(int i=0;i<a.length;i++)
    { for(int j=0;j<a[0].length;j++)
        { if(row[i]==0 || col[j]==0)
            { 
                a[i][j]=0;
            }
        }
    }
}
public static void main(String args[])
     { int matrix[][]={{1,1,1},
                       {1,0,1},
                       {1,1,1}
                       };
        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
           { System.out.print(matrix[i][j]+" "); 
            }
            System.out.println();
     }
    }
}