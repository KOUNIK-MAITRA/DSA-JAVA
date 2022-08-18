import java.io.*;
import java.util.*;
class LargestRectangleInHistogram
{
 public static void main(String args[]){
     int []heights={2,1,5,6,2,3};
     System.out.println(largestRectangleArea(heights));
 }
 static int largestRectangleArea(int[] heights) {
      
      int[]previousSmallerHeights=new int[heights.length];
      int[]nextSmallerHeights=new int[heights.length];
      
      //fill the previous smaller heights array using the previous smaller concept
      Stack<Integer> stack=new Stack<>();
        
      for(int i=0;i<heights.length;i++){
         while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
             stack.pop();
         if(stack.isEmpty())
             previousSmallerHeights[i]=-1;
          else
              previousSmallerHeights[i]=stack.peek();
          
          stack.push(i);
      }
       
        stack.clear();
        
      //fill the next smaller heights using next smaller concept
      for(int i=heights.length-1;i>=0;i--){
          while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
              stack.pop();
          if(stack.isEmpty())
              nextSmallerHeights[i]=heights.length;
          else
              nextSmallerHeights[i]=stack.peek();
          stack.push(i);
      }
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int left=previousSmallerHeights[i];
            int right=nextSmallerHeights[i];
            int area=heights[i]*(right-left-1);
                maxArea=Math.max(maxArea,area);
                
        }
        return maxArea;
        
    }
}
