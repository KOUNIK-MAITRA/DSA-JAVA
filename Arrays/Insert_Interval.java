import java.io.*;
import java.util.*;
 class Insert_Interval
{
    static class Interval{
        int start;
        int end;
        Interval(int start, int end)
        {
            this.start=start;
            this.end=end;
        }
    }
    public static void main(String args[]){
      int[][]intervals = {{1,3},{6,9}}; int newInterval[] = {2,5};
      ArrayList<Interval> finalIntervals=new ArrayList<>();

      int[][] ans=insert(intervals,newInterval);
      
      for(int arr[]: ans){
        System.out.print(Arrays.toString(arr));
        }
    }
    static int[][] insert(int[][] intervals, int[] newInterval) {
       ArrayList<Interval> intervalList=new ArrayList<>();
       
        for (int[] interval: intervals){
          intervalList.add(new Interval(interval[0],interval[1]));
        }
        
        Interval toInsert=new Interval(newInterval[0],newInterval[1]);
        
        
        intervalList=insertAndMerge( intervalList,toInsert);
        
        int[][] ans=new int[intervalList.size()][2];
      
        for(int i=0;i<intervalList.size();i++){
            ans[i][0]=intervalList.get(i).start;
            ans[i][1]=intervalList.get(i).end;
            }

         return ans;
    }
    
    static ArrayList<Interval> insertAndMerge(ArrayList<Interval> intervals, Interval newInterval){
        Interval toInsert=newInterval;
        int i=0;
        
        while(i<intervals.size())
        {
            Interval curr=intervals.get(i);
            
            if(toInsert.start>curr.end) // if the interval to insert is
                i++;
            else if( toInsert.end<curr.start)
            {
              intervals.add(i,toInsert);
              break;
            }
            
            else {
                toInsert.start=Math.min( toInsert.start,curr.start);
                toInsert.end=Math.max(toInsert.end,curr.end);
                intervals.remove(i);
            }
        }
        
        if(i==intervals.size())
            intervals.add(toInsert);
        
        return intervals;
    }
}
