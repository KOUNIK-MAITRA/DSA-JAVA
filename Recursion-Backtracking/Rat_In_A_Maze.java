 import java.io.*;
import java.util.*;
 class Rat_In_A_Maze
{
   public static void main(String args[]){
     int  n = 4;
     int m[][] ={{1, 0, 0, 0},
                 {1, 1, 0, 1}, 
                 {1, 1, 0, 0},
                 {0, 1, 1, 1}};
     System.out.println(findPath(m,n));            
    }
   static ArrayList<String> findPath(int[][] m, int n)
    {ArrayList<String>ans=new ArrayList<>();
     String res="";
     
     pathOfRat(0,0,n,m,res,ans);
    
     return ans;    
    }
   static void pathOfRat(int i, int j,int n,int[][]matrix,String res, ArrayList<String> ans)
    {  
       if(i==n-1 && j==n-1) 
       {
           ans.add(new String(res));
           return;
       }
       
       if(matrix[i][j]==0) 
        return;
       
       //up
       if(i-1>=0 &&  matrix[i-1][j]==1)
       {
           res+='U';
           matrix[i][j]=2;
           pathOfRat(i-1,j,n,matrix,res,ans);
           matrix[i][j]=1;
           res=res.substring(0,res.length()-1);
       }
       
       //down
       if(i+1<n &&  matrix[i+1][j]==1)
       {
           res+='D';
           matrix[i][j]=2;
           pathOfRat(i+1,j,n,matrix,res,ans);
           matrix[i][j]=1;
           res=res.substring(0,res.length()-1);
       }
       //left
       if(j-1>=0 && matrix[i][j-1]==1)
       {
           res+='L';
           matrix[i][j]=2;
           pathOfRat(i,j-1,n,matrix,res,ans);
           matrix[i][j]=1;
           res=res.substring(0,res.length()-1);
       }
       //right
       if(j+1<n && matrix[i][j+1]==1)
       {
           res+='R';
           matrix[i][j]=2;
           pathOfRat(i,j+1,n,matrix,res,ans);
           matrix[i][j]=1;
           res=res.substring(0,res.length()-1);
       }
       
       
    } 
}
