import java.io.*;
import java.util.*;
 class GridTriangle_Recursion
{
  public static void main(String args[])
  {
    }
  public int minimumTotal(List<List<Integer>> triangle) {
        return minSum(triangle,0,0);
    }
    
  public int minSum(List<List<Integer>> triangle,int i, int j)
    {
        if(i==triangle.size()-1)
            return triangle.get(triangle.size()-1).get(j);
        
        int down=triangle.get(i).get(j)+minSum(triangle,i+1,j);
        int up=triangle.get(i).get(j)+minSum(triangle,i+1,j+1);
        
        return Math.min(up,down);
    }
}
