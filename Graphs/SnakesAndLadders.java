import java.io.*;
import java.util.*;
class SnakesAndLadders
{
    static int snakesAndLadders(int[][] board){
        int n=board.length;
        Queue<Integer> queue= new LinkedList<>();
        boolean visited[]=new boolean[n*n+1];
        queue.offer(1);
        visited[1]=true;
        int moves=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int k=0;k<size;k++){
                int curr=queue.poll();
                for(int dice=1;dice<=6;dice++){
                    int nextPos=curr+dice;
                    int pos[]=numToPos(nextPos,n);
                    int nextRow=pos[0];
                    int nextCol=pos[1];
                    if(board[nextRow][nextCol]!=-1){
                        nextPos=board[nextRow][nextCol];
                    }
                    if(nextPos==n*n){
                        return moves;
                    }
                    if(!visited[nextPos]){
                        visited[nextPos]=true;
                        queue.offer(nextPos);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    static int[] numToPos(int target,int n) {
        int row = (target - 1) / n, col = (target - 1) % n;
        int x = n - 1 - row, y = row % 2 == 0 ? col : n - 1 - col;
        return new int[]{x, y};
    }

    public static void main(String args[]){
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};
        System.out.println(snakesAndLadders(board));
    }
}
