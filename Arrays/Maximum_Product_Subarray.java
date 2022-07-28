import java.io.*;
import java.util.*;
 class Maximum_Product_Subarray
{
  public static void main(String  args[]){
    int nums[]={2,3,-2,4};
    System.out.println(maxProduct(nums));
   }
  static int maxProduct(int[] nums) {
     int n=nums.length;   
     int ans=nums[0]; // store the first element as ans
     int max=ans; // store first ele as max
     int min=ans;// store the first element as min
     // because if the array conatined only 1 element then ans,max,min all equal to nums[0]   
       for(int i=1;i<n;i++){
            if(nums[i]<0) // if ele is -ve 
            { // swap the max and min
                int temp=max;
                max=min;
                min=temp;
            }
            
            max=Math.max(nums[i],nums[i]*max);
            min=Math.min(nums[i],nums[i]*min);
            
            ans=Math.max(ans,max);
        }
        
        return ans;
    } 
}
