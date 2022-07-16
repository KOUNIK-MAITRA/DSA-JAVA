import java.io.*;
import java.util.*;
 class Max_Area_Islands
{
   public static void main (String args[])
  {
      int[][] grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,1,1,0,1,0,0,0,0,0,0,0,0},
                    {0,1,0,0,1,1,0,0,1,0,1,0,0},
                    {0,1,0,0,1,1,0,0,1,1,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,0,0,0,0,0,0,1,1,0,0,0,0}};
      System.out.println(maxAreaOfIsland(grid));              
    }
  static int maxAreaOfIsland(int[][] grid) {        
      int rows=grid.length;
      int cols=grid[0].length;
      int max_Area=0;
      
        
      for(int i=0;i<rows;i++)
      { for(int j=0;j<cols;j++)
         {
          
            max_Area=Math.max(max_Area,area(grid,rows,cols,i,j));       
          }
      }
        
        return max_Area;
    }
    
  static int area(int[][] grid,int rows, int cols,int i, int j)
     {
         if(i<0 || j<0 || i>=rows || j>=cols)
             return 0;
         if(grid[i][j]==0 || grid[i][j]==2)
             return 0;
         
         grid[i][j]=2;
         
         return 1+area(grid,rows,cols,i+1,j)+area(grid,rows,cols,i-1,j)+
             area(grid,rows,cols,i,j-1)+area(grid,rows,cols,i,j+1);
     }
}
