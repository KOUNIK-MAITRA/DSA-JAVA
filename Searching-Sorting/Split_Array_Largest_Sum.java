import java.io.*;
import java.util.*; 
class Split_Array_Largest_Sum
{
    public static void main (String args[]){
      int nums[]={7,2,5,10,8}; 
      int m=2;
      
      System.out.println(splitArray(nums,m));
    }
     static int splitArray(int[] nums, int m) {
        
     int minElement=Integer.MIN_VALUE;
     int sum=0;
     
     for(int ele:nums){
        minElement=Math.min(minElement,ele);
        sum+=ele;
     }   
        
        int low=minElement; 
        int high=sum;
        int minimalLargestSum=Integer.MAX_VALUE;
       
        while(low<=high){
            int mid=(high+low)/2;
            
            if(isPossible(nums,mid,m)){
                minimalLargestSum=mid;
                high=mid-1;
            }
            else
                low=mid+1;
            
        }
        
        return minimalLargestSum;
    }
    
    static boolean isPossible(int[] nums, int currSum,int m){
        int sum=0; int subArrays=1; 
        
        for(int i=0;i<nums.length;i++){
         
            if(nums[i]>currSum)
                return false;
          
            if(sum+nums[i]>currSum){
                subArrays++;
                sum=nums[i];
                
                if(subArrays>m)
                    return false;
            }
            else{
                sum+=nums[i];
            }
        }       
         return true;
    }
}
