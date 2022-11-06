import java.io.*;
import java.util.*;
class Number_of_Distinct_Islands 
{

    static int countDistinctIslands(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];

        HashSet<List<List<Integer>>> set = new HashSet<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j] && grid[i][j]==1)
                {
                    List<List<Integer>> island = new ArrayList<>();
                    DFS(i,j,i,j,grid,visited,island);
                    set.add(island);
                }
            }
        }

        return set.size();
    }

    static void DFS(int row, int col,int srcRow, int srcCol,int [][]grid,boolean [][]visited,List<List<Integer>> island)
    {
        int n=grid.length;
        int m=grid[0].length;

        if(row<0 || row>=n || col<0 || col>=m || visited[row][col] || grid[row][col]==0)
            return;

        visited[row][col]=true;

        List<Integer> coordinates=new ArrayList<>();
        coordinates.add(srcRow-row);
        coordinates.add(srcCol-col);
        island.add(coordinates);

        DFS(row-1,col,srcRow,srcCol,grid,visited,island);
        DFS(row+1,col,srcRow,srcCol,grid,visited,island);
        DFS(row,col-1,srcRow,srcCol,grid,visited,island);
        DFS(row,col+1,srcRow,srcCol,grid,visited,island);

    }

    public static void main(String args[])
    {
        int grid[][] = {{1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}};
        System.out.println(countDistinctIslands(grid));                
    }
}
