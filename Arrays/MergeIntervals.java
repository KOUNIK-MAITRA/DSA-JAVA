// merge overlapping sub intervals // 
import java.io.*;
import java.util.*;
class MergeIntervals
{ 
   public static int [][]merge(int [][] intervals)
   { List<int[]> res=new ArrayList<>();
       
      if(intervals.length==0 || intervals==null)
       return intervals;
       
       Arrays.sort(intervals,(a,b)-> a[0]-b[0]);//sort according to the start time //
       
       int start=intervals[0][0];
       int end=intervals[0][1];
       
       for(int [] i: intervals)
       { if(i[0]<=end)
           { end=Math.max(end,i[1]); // merge the intervals that can be merged //
            }
           else 
           { res.add(new int[]{start,end}); 
             start=i[0];
             end=i[1];
            }
        }
        res.add(new int []{start,end});
        return res.toArray(new int[0][]);        
    }
    
    public static void main (String args[])
    { 
        int intervals[][]={{1,3},{2,6},{8,10},{15,18}};
         int ans[][]=merge(intervals);
         for(int i=0;i<ans.length;i++)
         {for (int j=0;j<ans[i].length;j++)
            {System.out.print (ans[i][j] +" ");
            }
              System.out.println();
        }
    }
}