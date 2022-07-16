import java.io.*;
import java.util.*;
class Game_of_Life
{
    public static void main (String args[])
    {
        int [][] board={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int rows=board.length;
        int cols=board[0].length;
        for(int i=0;i<rows;i++)
        { for (int j=0;j<cols;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        gameOfLife(board);
        System.out.println();
         for(int i=0;i<rows;i++)
        { for (int j=0;j<cols;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void gameOfLife(int[][] board) {
          // 0 and stays 0 
         // 1 and stays 1
        // 0 and becomes alive then 2
       // 1 and becomes dead then 3
      // check count of 1 and 3 at 8 positions
        
      int n=board.length;
      int m=board[0].length;
        
      for(int i=0;i<n;i++)
      { for(int j=0;j<m;j++)
         {
           if(board[i][j]==1)
           {
             if(countOnes(board,i,j)<2 || countOnes(board,i,j)>3)
                 board[i][j]=3;
           }
          
          else
              
          {
              if(countOnes(board,i,j)==3)
                  board[i][j]=2;
          }
          
          }
       }
        
        fixboard(board,n,m);
        
    }
    
    static int countOnes (int [][] board, int row, int col)
    {
         int countOne = 0;
        
        //topleft
         if(row > 0 && col > 0){
            if(board[row-1][col-1] == 1 || board[row-1][col-1] == 3) countOne++;
        } 
        
        
        //top
        if(row > 0){
            if(board[row-1][col]== 1 || board[row-1][col] == 3) countOne++;
        }
        
        //topright
        if(row > 0 && col<board[0].length-1){
            if(board[row-1][col+1]== 1 || board[row-1][col+1] == 3) countOne++;
        }
        //left
        if(col > 0){
            if(board[row][col-1]== 1 || board[row][col-1] == 3) countOne++;
        }
        //right
        if(col < board[0].length -1){
            if(board[row][col+1]== 1 || board[row][col+1] == 3) countOne++;
        }
        //bottomleft
        if(row < board.length-1 && col > 0){
            if(board[row+1][col-1]== 1 || board[row+1][col-1] == 3) countOne++;
        }
        //bottom
        if(row < board.length-1){
            if(board[row+1][col]== 1 || board[row+1][col] == 3) countOne++;
        }
        //bottomright
        if(row < board.length-1 && col<board[0].length-1){
            if(board[row+1][col+1]== 1 || board[row+1][col+1] == 3) countOne++;
        }
        return countOne;
    }
    
    static void fixboard(int [][]board,int n, int m)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==2)
                   board[i][j]=1;
                if(board[i][j]==3)
                   board[i][j]=0;
            }
        }
    }
}