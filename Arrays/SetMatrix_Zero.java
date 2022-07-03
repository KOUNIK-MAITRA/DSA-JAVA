import java.io.*;
import java.util.*;
public class SetMatrix_Zero
{
    public static void main(String args[])
    {
      int matrix[][]={{1,1,1},{1,0,1},{1,1,1}};
      setZeroes(matrix);
      
      for(int i=0;i<matrix.length;i++)
      { for(int j=0;j<matrix[0].length;j++)
          { System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean col0=true;
        
        // while filing dummy arrays//
        for (int i=0;i<rows;i++)
        {
            if(matrix[i][0]==0)
                col0=false;
            for(int j=1;j<cols;j++)
            {
                if(matrix[i][j]==0)
                    matrix[i][0]=matrix[0][j]=0; // 0th row and 0th col as the dummy arrays
            }
        }
        
        
        // while filling the 2d matrix//
        
        for(int i=rows-1;i>=0;i--)
        {
            for(int j=cols-1;j>=1;j--)
            { if(matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;
            }
            if(col0==false)
                matrix[i][0]=0; // make the first col to be 0
        }
        
    }
}
