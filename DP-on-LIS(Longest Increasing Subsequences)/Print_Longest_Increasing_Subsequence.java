import java.io.*;
import java.util.*;
 class Print_Longest_Increasing_Subsequence
{
   public static void main(String args[]){
       int nums[]={0,1,0,3,2,3};
       ArrayList<Integer> LIS= new ArrayList<Integer>();
       LIS=longestIncreasingSubsequence(nums);
       System.out.println(LIS);
   }
   static ArrayList<Integer> longestIncreasingSubsequence(int nums[]){
      ArrayList<Integer> LIS=new ArrayList<>();
      int n=nums.length;
      int dp[]=new int [n]; //dp[i] stores the length of LIS ending with nums[i]
      Arrays.fill(dp,1);
      int prev[]=new int [n]; //prev[i] stores the index of prev number before nums[i]
     
      for(int i=0;i<n;i++){
        //initially all numbers singly make the LIS with itself
        //hence the index of prev elements are initially set to the index of the element itself
        prev[i]=i; 
        }
        
     for(int i=0;i<n;i++){
       int curr=i;
       //check all elements that appear before the curr element
       for(int prev_index=0;prev_index<curr;prev_index++){
          // if the previous number < curr number
          if(nums[prev_index]<nums[curr]){
            // update the length of the LIS if  
             if(dp[prev_index]+1>dp[curr])
             { dp[curr]=dp[prev_index]+1;
                prev[curr]=prev_index;//store the index of the previous element
            }
            }
        }
        }
     int maxLength=0;
     int LISindex=-1;
     for(int i=0;i<n;i++){
        if(dp[i]>maxLength){
         maxLength=dp[i];//find the length of the LIS
         LISindex=i;// store the index of the number with which the LIS ends
        }
        }
     // while the prev element in LIS is not itself
     while(prev[LISindex]!=LISindex){
         LIS.add(nums[LISindex]);//add the number to LIS
         LISindex=prev[LISindex];// go back to the index of the number which came prior to the curr 
        }
        
       LIS.add(nums[LISindex]); // add the last prev element or the start of the LIS
       Collections.reverse(LIS); // reverse the list to make it increasing
       return LIS;
    } 
}
