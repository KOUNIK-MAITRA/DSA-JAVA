import java.io.*;
import java.util.*;
class Number_Of_Islands
{
   public static void main(String args[])
   {
       char grid[][]={ {'1','1','1','1','0'},
                       {'1','1','0','1','0'},
                       {'1','1','0','1','0'},
                       {'1','1','0','1','0'}};
                       
        System.out.println(numIslands(grid));               
    }
   static int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        
        int count_Islands=0;
        
        for(int i=0;i<rows;i++)
        { for(int j=0;j<cols;j++)
          {
             if(grid[i][j]=='1')
             {
                 count_Islands++;
                 markIslands(grid,rows,cols,i,j);
             }
            }
        }
        
        return count_Islands;
    }
    
   static void markIslands(char[][] grid, int rows, int cols,int i, int j)
    {
      
      if(i<0||j<0||i>=rows||j>=cols)
          return;
      if(grid[i][j]=='0' || grid[i][j]=='2')
          return;
     
        grid[i][j]='2';
        
         markIslands(grid,rows,cols,i-1,j);
         markIslands(grid,rows,cols,i+1,j);
         markIslands(grid,rows,cols,i,j-1);
         markIslands(grid,rows,cols,i,j+1);
    }
}
