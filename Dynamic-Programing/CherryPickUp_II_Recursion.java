import java.io.*;
import java.util.*;
 class CherryPickUp_II_Recursion
{
    public static void main(String args[])
    {
        int grid[][]={{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(cherryPickup(grid) );
    }
      static int cherries( int grid[][], int rows, int cols, int i,int j1, int j2)
    {
        //checking out of grid conditions
        if(j1<0||j2<0||j1>=cols||j2>=cols)
            return -(int)1e9;
        
        // if they reached last row
        if(i==rows-1)
        {
            if(j1==j2)// if both reached the same col in last row
                return grid[i][j1]; // consider only one
            else // if both reached different cols 
                return grid[i][j1]+grid[i][j2]; // find total cherries from both cells
        }
        
        // calculating total cherries picked from their curr cells
        int currCherries=0;
        
                if(j1==j2) // if both are at same cells
                    currCherries=grid[i][j1];
                else // if both are at different cells
                    currCherries=grid[i][j1]+grid[i][j2];
        
        int maxCherries=-(int)1e9;
        
        // for every 1 move of robo 1 there are 3 moves of robo 2
        // therefore for every 3 move of robo1 there are 9 moves of robo2
        
        // no matter what move is made both will go down one row
        
        // for col there are 3 possible moves
        // -1,0,1-->left col, same col, right col but one row down
        
        for(int direction_1=-1;direction_1<=1;direction_1++) // every move of robo1
        {
            for(int direction_2=-1;direction_2<=1;direction_2++) //every move of robo2
            {
              // calculating total cherries  
               int totalCherries=currCherries+cherries(grid,rows,cols,i+1,j1+direction_1,j2+direction_2);
              // calculating the max cherries collected
                maxCherries=Math.max(maxCherries,totalCherries);
            }
        }
        
        return maxCherries;
    }
    
    static int cherryPickup(int[][] grid) {
      return cherries(  grid,grid.length,grid[0].length,0,0,grid[0].length-1);
    }
}
