import java.io.*;
import java.util.*;
 class SudokuSolver
{
    public static void main(String args[]){
     char [][]board={{'5','3','.','.','7','.','.','.','.'},
                     {'6','.','.','1','9','5','.','.','.'},
                     {'.','9','8','.','.','.','.','6','.'},
                     {'8','.','.','.','6','.','.','.','3'},
                     {'4','.','.','8','.','3','.','.','1'},
                     {'7','.','.','.','2','.','.','.','6'},
                     {'.','6','.','.','.','.','2','8','.'},
                     {'.','.','.','4','1','9','.','.','5'},
                     {'.','.','.','.','8','.','.','7','9'}};
     solveSudoku(board);                
     for(char[] row : board)
      System.out.println(Arrays.toString(row));
    }
    
    static void solveSudoku(char[][] board) {
     solve(board);   
    }
    
    static boolean solve(char[][]board){
        for(int i=0;i<9;i++)
        {
          for(int j=0;j<9;j++)
          {
            if(board[i][j]=='.')
            {
              for(char num='1';num<='9';num++)
              {
                  if(isValid(i,j,num,board))
                  {
                    board[i][j]=num;
                    if(solve(board)) 
                     return true;
                    else 
                     board[i][j]='.';                        
                  }
              }
              return false;
            }
          }
        }
        return true;  
    }
    
    static boolean isValid(int row, int col, char num, char[][]board){
      int gridStartRow=3*(row/3);  
      int gridStartCol=3*(col/3);
     
      for(int i=0;i<9;i++)
      {
        if(board[row][i]==num) 
         return false;
        if(board[i][col]==num) 
         return false;  
        if(board[gridStartRow+i/3][gridStartCol+i%3]==num) 
         return false;  
      }
     
      return true;
      
    }
}
