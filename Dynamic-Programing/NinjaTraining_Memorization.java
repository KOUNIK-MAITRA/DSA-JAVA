import java.io.*;
import java.util.*;
class NinjaTraining_Memorization
{
    public static void main(String args[])
    {   int n=3;
        int [][]points={{1,2,5},{3,1,1},{3,3,3}};
        System.out.println(ninjaTraining(n,points));
    }
    public static int ninjaTraining(int n, int points[][])
    { 
       int [][]dp=new int [n][4];
      
       for(int rows=0;rows<n;rows++)
       { for(int col=0;col<4;col++)
           { dp[rows][col]=-1;
            }
        }
        
      return maxPoints(n-1,3,points,dp);
          
    }
    public static int maxPoints(int day,int last,int[][] points ,int dp[][])
    {
        if(day==0)
        { int max_points=0;
          for(int task=0;task<3;task++)
          { if(task!=last)
              { max_points=Math.max(max_points,points[0][task]);
                }
            }
            return max_points;
        }
        if(dp[day][last]!=-1)
        return dp[day][last];
        int maxPoints=0;
        for(int task=0;task<3;task++)
        { 
            if(task!=last)
            { maxPoints=Math.max(maxPoints,(points[day][task]+maxPoints(day-1,task,points,dp)));
            }
         }
         return dp[day][last]=maxPoints;
    }
}