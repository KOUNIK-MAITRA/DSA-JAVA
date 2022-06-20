import java.io.*;
import java.util.*;
class NinjaTraining_SpaceOptimization
{
    public static void main(String args[])
    {   int n=3;
        int [][]points={{1,2,5},{3,1,1},{3,3,3}};
        System.out.println(ninjaTraining(n,points));
    }
    public static int ninjaTraining(int n, int points[][])
    { 
       int []prev=new int[4];
       prev[0]=Math.max(points[0][1],points[0][2]); 
       prev[1]=Math.max(points[0][0],points[0][2]); 
       prev[2]=Math.max(points[0][1],points[0][0]); 
       prev[3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2])); 
       
       for(int day=1;day<n;day++)
       { int []temp=new int [4];
           for(int last=0;last<4;last++)
           { temp[last]=0;
               for(int task=0;task<3;task++)
               { if (task!=last)
                   {
                     int point=points[day][task]+prev[task];
                     temp[last]=Math.max(temp[last],point);
                    }
                }
            }
            prev=temp;
        }      
        return prev[3];          
    }
    }
