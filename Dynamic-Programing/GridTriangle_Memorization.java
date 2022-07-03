import java.io.*;
import java.util.*;
 class GridTriangle_Memorization
{
  public static void main(String args[])
  {  List<ArrayList<Integer>> Triangle = new ArrayList<ArrayList<Integer>>();
     ArrayList<Integer> row1=new ArrayList<>();
     row1.add(2);
     ArrayList<Integer> row2=new ArrayList<>();
     row2.add(3);
     row2.add(4);
     ArrayList<Integer> row3=new ArrayList<>();
     row3.add(5);
     row3.add(6);
     row3.add(7);
     ArrayList<Integer> row4=new ArrayList<>();
     row4.add(4);
     row4.add(1);
     row4.add(8);
     row4.add(3);
     Triangle.add(row1);
     Triangle.add(row2);
     Triangle.add(row3);
     Triangle.add(row4);
    
     System.out.println(minimumTotal(Triangle));
    }
   public static int minimumTotal(List<ArrayList<Integer>> triangle) {
    
        int m =triangle.size();
        int n =triangle.get(triangle.size()-1).size();
        int dp[][]=new int [m][n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
                dp[i][j]=-1;
        }
        
          return minSum(triangle,0,0,dp,m,n);
    }
    
    public static int minSum(List<ArrayList<Integer>> triangle,int i, int j,int dp[][],int m, int n)
    {
        if(i==m-1)
            return triangle.get(m-1).get(j);
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int down=triangle.get(i).get(j)+minSum(triangle,i+1,j,dp,m,n);
        int up=triangle.get(i).get(j)+minSum(triangle,i+1,j+1,dp,m,n);
        
        return dp[i][j]=Math.min(up,down);
    }
}
