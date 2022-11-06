import java.io.*;
import java.util.*;
class Number_of_Enclaves {

    static int numEnclaves(int[][] grid) 
    {
        int m=grid.length; 
        int n=grid[0].length;
        int count=0; 
        boolean visited[][]=new boolean[m][n]; 

        for(int col=0;col<n;col++)
        {
            if(grid[0][col]==1 && !visited[0][col])
                DFS(0,col,grid,visited);

            if(grid[m-1][col]==1 && !visited[m-1][col])
                DFS(m-1,col,grid,visited);              
        }

        for(int row=0;row<m;row++)
        {
            if(grid[row][0]==1 && !visited[row][0])
                DFS(row,0,grid,visited);

            if(grid[row][n-1]==1 && !visited[row][n-1])
                DFS(row,n-1,grid,visited);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && !visited[i][j])
                    count++;
            }
        }

        return count;
    }

    static void DFS(int row, int col, int[][] grid,boolean visited[][])
    {
        int m=grid.length;
        int n=grid[0].length;

        visited[row][col]=true;

        int [][]directions={{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] direction : directions)
        {
            int nextRow=row+direction[0];
            int nextCol=col+direction[1];

            if(nextRow>=0 && nextRow<m &&
            nextCol>=0 && nextCol<n &&
            !visited[nextRow][nextCol] && grid[nextRow][nextCol]==1)

                DFS(nextRow,nextCol,grid,visited);
        }
    }

    public static void main(String args[])
    {
       int [][]grid={{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}; 
       System.out.println(numEnclaves(grid));
    }
}