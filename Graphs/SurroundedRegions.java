import java.io.*;
import java.util.*;
class SurroundedRegions {
    //* Intuition : O's will NOT be converted to X only and only if they are either 
    // on the boundary or connected with an O that is on the boundary
    // find all boundary Os and run DFS and mark visited all the Os connected with the boundary Os 
    // now conver all Os that are not visited 
    static void solve(char[][] board) {

        int m=board.length;
        int n=board[0].length;

        boolean[][] visited=new boolean[m][n];

        // find all boundary Os and mark them visited usig DFS 

        for(int col=0;col<n;col++)
        {
            if(!visited[0][col] && board[0][col]=='O')
                DFS(0,col,board,visited);

            if(!visited[m-1][col] && board[m-1][col]=='O')
                DFS(m-1,col,board,visited);
        }

        for(int row=0;row<m;row++)
        {  
            if(!visited[row][0] && board[row][0]=='O')
                DFS(row,0,board,visited);

            if(!visited[row][n-1] && board[row][n-1]=='O')
                DFS(row,n-1,board,visited);
        }

        // replace all Os that are NOT visited with X 
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && !visited[i][j])
                    board[i][j]='X';
            }
        }   

    }

    static void DFS (int row, int col, char[][]board, boolean[][]visited)
    {
        int m=board.length;
        int n=board[0].length;
        visited[row][col]=true;

        int [][] directions={{1,0},{-1,0},{0,1},{0,-1}};

        for(int [] direction : directions)
        {
            int nextRow=row+direction[0];
            int nextCol=col+direction[1];

            if(
            nextRow>=0 && nextRow<m   && 
            nextCol>=0 && nextCol<n   && 
            !visited[nextRow][nextCol] &&
            board[nextRow][nextCol]=='O'
            )

            {
                DFS(nextRow,nextCol,board,visited);
            }
        }
    }

    public static void main(String args[])
    {
        char board[][]={{'X','X','X','X'},
                        {'X','O','O','X'},
                        {'X','X','O','X'},
                        {'X','O','X','X'}};
         
        solve(board);                
        for(char arr[]:board)
        {
            System.out.println(Arrays.toString(arr));
        }
    }    
}
