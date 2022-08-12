import java.io.*;
import java.util.*;
 class Largest_Divisible_Subset
{
  public static void main(String args[]){
      int nums[]={1,16,4,7,8};
      System.out.println(largestDivisibleSubset(nums));
    }
  static List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
       
        Arrays.sort(nums);
      
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        
        int prev[]=new int[n];
        for(int i=0;i<n;i++)
            prev[i]=i;
    
        for(int i=0;i<n;i++){
          int curr=i;
            for(int j=0;j<curr;j++){    
               
                if(nums[curr]%nums[j]==0){ 
                    if(dp[j]+1>dp[curr]){
                      dp[curr]=dp[j]+1;
                      prev[curr]=j;}
                }                
            }
        }
            
        int maxLength=0;
        int index=-1;  
          
        for(int i=0;i<n;i++)
          {
              if(dp[i]>maxLength)
              {
                  maxLength=dp[i];
                  index=i;
              }
          }
         ArrayList<Integer> ans= new ArrayList<>();  

        while(prev[index]!=index){
             ans.add(nums[index]);
             index=prev[index];
           }
        ans.add(nums[index]);
            return ans;
            
        }
}
