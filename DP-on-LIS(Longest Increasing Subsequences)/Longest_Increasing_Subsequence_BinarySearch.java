import java.io.*;
import java.util.*;
 class Longest_Increasing_Subsequence_BinarySearch
{
  public static void main(String args[]){
      int nums[]={0,3,1,6,2,2,7};
      System.out.println(LIS_using_BinarySearch(nums));
   }
  static int LIS_using_BinarySearch(int nums[]){
      int n=nums.length;
      int[] dp=new int[n];
      int LISlength=0;
      
      //search for all elements in the nums array
      for(int ele:nums){
        //find the index where this element should be inserted in the dp array  
        int index_to_insert=Arrays.binarySearch(dp,0,LISlength,ele); 
        
        //Arrays.binarySearch() returns in -ve if the number is not present in the array
        // position to insert = -(i+1) where is the -ve value returned by binarySearch func
        if(index_to_insert<0){
          index_to_insert=-(index_to_insert+1);
        }
        dp[index_to_insert]=ele;// insert the element in the proper position
        if(index_to_insert==LISlength)//if the index to insert==length of the LIS
        //i.e we are inserting the element at the end of LIS
        //increase the length of the LIS
         LISlength++;
        }
      
      return LISlength;
    } 
}
