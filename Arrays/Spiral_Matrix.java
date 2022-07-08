import java.io.*;
import java.util.*;
 class Spiral_Matrix
{
   public static void main(String args[])
   {
       int matrix[][]={{1,2,3},{4,5,6},{7,8,9}};
       System.out.println(spiralOrder(matrix));
    }
    static List<Integer> spiralOrder(int[][] matrix) {
        List <Integer> ans=new ArrayList<>();
        
        int top=0; int left=0; int right=matrix[0].length-1; int bottom=matrix.length-1;
        
        int dir=0;
        
        // dir=0 => left to right
        // dir=1 => top to bottom
        // dir=2 => right to left
        // dir=3 => bottom to top
        
        while(top<=bottom && left<=right)
        {
            if(dir==0)
            {
                for(int i=left;i<=right;i++)
                 ans.add(matrix[top][i]);
                 
                top++; 
            }
            
            else if (dir==1)
            {
                for(int i=top;i<=bottom;i++)
                 ans.add(matrix[i][right]);
                 
                right--; 
            }
            
            else if(dir==2)
            {
                for(int i=right;i>=left;i--)
                 ans.add(matrix[bottom][i]);
                
                bottom--;
            }
            
            else 
            {
                for(int i=bottom;i>=top;i--)
                 ans.add(matrix[i][left]);
                
                 left++;
            }
            
            dir=(dir+1)%4;
        }
        
        return ans;
    }
}
