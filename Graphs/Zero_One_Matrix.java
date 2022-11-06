import java.io.*;
import java.util.*;
class Zero_One_Matrix
{
    static class Cell{
        int row;
        int col;
        int minDist;
        Cell(int row, int col, int minDist)
        {
            this.row=row;
            this.col=col;
            this.minDist=minDist;
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {

        int m=matrix.length;
        int n=matrix[0].length;

        int [][]visited=new int[m][n];
        int [][]distance=new int[m][n];

        Queue<Cell> queue = new LinkedList<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    queue.offer(new Cell(i,j,0));
                    visited[i][j]=1;
                }
            }
        }

        while(!queue.isEmpty())
        {
            Cell curr=queue.poll();
            int currRow=curr.row;
            int currCol=curr.col;
            int currDist=curr.minDist;

            distance[currRow][currCol]=currDist;

            if(currRow-1>=0 && visited[currRow-1][currCol]==0)
            {
                visited[currRow-1][currCol]=1;
                queue.offer(new Cell(currRow-1,currCol,currDist+1));
            }

            if(currRow+1<m && visited[currRow+1][currCol]==0)
            {
                visited[currRow+1][currCol]=1;
                queue.offer(new Cell(currRow+1,currCol,currDist+1));
            }

            if(currCol-1>=0 && visited[currRow][currCol-1]==0)
            {
                visited[currRow][currCol-1]=1;
                queue.offer(new Cell(currRow,currCol-1,currDist+1));
            }

            if(currCol+1<n && visited[currRow][currCol+1]==0)
            {
                visited[currRow][currCol+1]=1;
                queue.offer(new Cell(currRow,currCol+1,currDist+1));
            }
        }

        return distance;
    }

    public static void main(String args[])
    {
        int [][]matrix = {{0,0,0},{0,1,0},{1,1,1}};
        int ans[][]=updateMatrix(matrix);
        for(int[] arr:ans)
        {
            System.out.println(Arrays.toString(arr));
        }
    }
}