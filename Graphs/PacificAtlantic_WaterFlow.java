import java.io.*;
import java.util.*;
 class PacificAtlantic_WaterFlow
{
    public static void main(String args[])
    {
        int [][]heights = {{1,2,2,3,5},
                           {3,2,3,4,4},
                           {2,4,5,3,1},
                           {6,7,1,4,5},
                           {5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }
    // the basic idea is we start from the ocean and try to see which cells can we visit
    // if we can visit a land from both atlantic and pacific ocean we add that cell to or ans
    // hence in our case water can flow to neighboring cells directly north, south, east, and west if the         //neighboring cell's height is greater than or equal to the current cell's height.   
    static List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        int m=heights.length;
        int n=heights[0].length;
        int directions[][]={{-1,0},{1,0},{0,-1},{0,1}}; // for convinience we make an directions array
        List<List<Integer>> ans = new ArrayList<>();
        // a boolean viisted matrix for atlantic ocean 
        // if atlantic[i][j]=true then it is possible to reach heights[i][j] from the atlantic ocean
        boolean[][] atlantic = new boolean[m][n]; 
        // smilarly, a boolean viisted matrix for pacific ocean 
        // if pacific[i][j]=true then it is possible to reach heights[i][j] from the pacific ocean
        boolean[][] pacific = new boolean[m][n];
        
        int oceanHeight=Integer.MIN_VALUE;// for convinience we consider the oceans height to be INT_MIN
        
        // all cells in the top row can be reached by pacific ocean
        // all cells in the bottom row can be reached by the atlantic ocean
        // so we call a dfs function and find out all the adjacent cells that have a greater or equal height
        // and mark them visited for their respective oceans
        for(int i=0;i<m;i++)
        {
            dfs(i,0,oceanHeight,heights,pacific,directions);// top row -- pacific ocean
            dfs(i,n-1,oceanHeight,heights,atlantic,directions);// bottom row --- atlantic ocean
        }
        // all cells in the first col can be reached by pacific ocean
        // all cells in the last col can be reached by the atlantic ocean
        // so we call a dfs function and find out all the adjacent cells that have a greater or equal height
        // and mark them visited for their respective oceans
        for(int j=0;j<n;j++)
        {
            dfs(0,j,oceanHeight,heights,pacific,directions);// first col --- pacific ocean
            dfs(m-1,j,oceanHeight,heights,atlantic,directions);// last col --- atlantic ocean
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                // if a cell is marked visited in both pacific and atlantic we add it to the ans
                if(pacific[i][j] && atlantic[i][j]) 
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        
        return ans;
        
    }
    
    static void dfs (int i ,int j, int height, int[][]heights, boolean[][]visited, int[][]directions)
    {
      int m=heights.length;
      int n=heights[0].length;  
      // if the cell is out of bounds or has a height less than the prev cell return  
      if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || heights[i][j]<height)
          return;
        // if it is a valid cell mark it visited
        visited[i][j]=true;
        
        for(int direction[] : directions)// call dfs for all the 4 directions
        {
            dfs(i+direction[0],j+direction[1],heights[i][j],heights,visited,directions);
        }
    }
}
