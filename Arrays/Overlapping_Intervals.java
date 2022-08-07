import java.io.*;
import java.util.*;
 class Overlapping_Intervals
{
    public static void main(String args[]){
       int [][] intervals = {{1,2},{2,3},{3,4},{1,3}};
       System.out.println(eraseOverlapIntervals(intervals));
    }
    static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) 
         return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); //sort the intervals according to the start time
        
        int prevEnd = intervals[0][1];
        int count = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            // if the start time of the curr interval is less than the end time of the prev then overlap exits
            if (prevEnd > intervals[i][0]) {
                count++;
                prevEnd = Math.min(intervals[i][1], prevEnd); // keep the interval with min end time
            } 
            // incase of no overlap update the prev end
            else {
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}
