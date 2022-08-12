import java.io.*;
import java.util.*;
 class RottenOranges
{
  static class Pair{
        int row;
        int col;
        int time;
        
        Pair(int row, int col, int time){
            this.row=row;
            this.col=col;
            this.time=time;            
        }
     }
  static int orangesRotting(int[][] grid) {
       Queue<Pair> queue= new LinkedList<>();
       
        int n=grid.length;
        int m=grid[0].length;
        int countFresh=0;
       
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    queue.add(new Pair(i,j,0));
                else if(grid[i][j]==1)
                    countFresh++;
              }
            }
       
        if(countFresh==0)return 0;
        
        int timeTaken=0;
        
        while(!queue.isEmpty()){
            
            Pair currOrange=queue.poll();

             int currRow=currOrange.row;
             int currCol=currOrange.col;
             int currTime=currOrange.time;
            
             //top
             if(currRow-1>=0 && grid[currRow-1][currCol]==1)
             {grid[currRow-1][currCol]=2; countFresh--;
              queue.add(new Pair(currRow-1,currCol,currTime+1));
              timeTaken=Math.max(timeTaken,currTime+1);
             }
            //left
             if(currCol-1>=0 && grid[currRow][currCol-1]==1)
             {grid[currRow][currCol-1]=2; countFresh--;
              queue.add(new Pair(currRow,currCol-1,currTime+1));
              timeTaken=Math.max(timeTaken,currTime+1);
             }
            //right
             if(currCol+1<m && grid[currRow][currCol+1]==1)
             {grid[currRow][currCol+1]=2; countFresh--;
              queue.add(new Pair(currRow,currCol+1,currTime+1));
              timeTaken=Math.max(timeTaken,currTime+1);
             }
            //bottom
             if(currRow+1<n && grid[currRow+1][currCol]==1)
             {grid[currRow+1][currCol]=2; countFresh--;
              queue.add(new Pair(currRow+1,currCol,currTime+1));
              timeTaken=Math.max(timeTaken,currTime+1);
             }
            
        }
        
       if(countFresh!=0) 
        return -1;
        
        return timeTaken;
        
    }
     public static void main(String args[]){
         int[][]grid={{2,1,1},{1,1,0},{0,1,1}};
         System.out.println(orangesRotting(grid));
    }
}

