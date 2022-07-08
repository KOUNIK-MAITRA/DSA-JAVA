import java.io.*;
import java.util.*;
 class Container_With_Most_Water
{
    public static void main(String args[])
    {
        int height[]={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    static int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right)
        {
            int left_height=height[left];
            int right_height=height[right];
            int distance =right-left;
            max=Math.max(max,Math.min(left_height,right_height)*distance);
            if (left_height<right_height)
                left++;
            else 
                right--;
        }
        return max;
        
    }
  
}
