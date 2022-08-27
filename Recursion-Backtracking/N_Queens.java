import java.io.*;
import java.util.*;
class N_Queens
{
    public static void main(String args[]){
      int n=4;
      System.out.println(solveNQueens(n));
    }
     static List<List<String>> solveNQueens(int n) {
       char board[][]=new char[n][n]; //create a board of n x n
       for(char[] arr: board) //fill the entire board with '.'
       Arrays.fill(arr,'.');
       List<List<String>> ans= new ArrayList<>(); 
       solve(0,board,ans); // start solving from the 0th column
       return ans; 
    }
       
    static void solve(int colIndex, char[][]board,List<List<String>> ans)
    {
        //note : there can be only 1 queen in a single row and 1 queen in a single column   
        // if we have placed a queen in every column then we have a valid board
        // we add the board to our ans    
        if(colIndex==board.length)
        {
            ans.add(construct(board));
            return;
        }
        // iterate over each row for the column : colIndex
        // find a position to place the queen    
        for(int i=0;i<board.length;i++){
         if(canPlaceQueen(board,i,colIndex))// if we can place a queen in row : i and col:colIndex
         {
                board[i][colIndex]='Q'; // place a queen
                solve(colIndex+1,board,ans);// call recursive function to solve for next columns
                board[i][colIndex]='.';// remove the queen while backtracking
            }
        }
     }
    
    static boolean canPlaceQueen(char[][]board, int row,int colIndex)
    {
        
       int currRow=row; int currCol=colIndex;
       
        // check if there is a queen in the upper left diagonal
        while(currRow>=0 && currCol>=0)
        {
            if(board[currRow--][currCol--]=='Q') return false;
        } 
        currRow=row; currCol=colIndex;
      
        //check if there is a queen in the left side of the same row
        while(currCol>=0)
        {
            if(board[currRow][currCol--]=='Q') return false;
        }
        currRow=row; currCol=colIndex;
        
        // check if there is a queen in the bottom left diagonal 
        while(currRow<board.length && currCol>=0)
        {
            if(board[currRow++][currCol--]=='Q') return false;
        }
        
        return true;
    }
    
    static ArrayList<String> construct(char[][]board)
    {
       // covnvert the board to a list of string to add it to the ans list
        ArrayList<String> res= new ArrayList<>();
        for(char[] row:board){
         res.add(new String(row));   
        }
        return res;
     }
}

