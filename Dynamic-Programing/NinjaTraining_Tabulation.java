import java.io.*;
import java.util.*;
class NinjaTraining_Tabulation
{
    public static void main(String args[])
    {   int n=3;
        int [][]points={{1,2,5},{3,1,1},{3,3,3}};
        System.out.println(ninjaTraining(n,points));
    }
    public static int ninjaTraining(int n, int points[][])
    { 
       int [][]dp=new int [n][4];
       dp[0][0]=Math.max(points[0][1],points[0][2]); 
       dp[0][1]=Math.max(points[0][0],points[0][2]); 
       dp[0][2]=Math.max(points[0][1],points[0][0]); 
       dp[0][3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2])); 
       
       for(int day=1;day<n;day++)
       { for(int last=0;last<4;last++)
           { dp[day][last]=0;
               for(int task=0;task<3;task++)
               { if (task!=last)
                   {
                     int point=points[day][task]+dp[day-1][task];
                     dp[day][last]=Math.max(dp[day][last],point);
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++)
        { for(int j=0;j<4;j++)
            { System.out.print(dp[i][j]+"   ");}
            System.out.println();
        }
        return dp[n-1][3];
      
          
    }
   
       
    }
