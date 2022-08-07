import java.io.*;
import java.util.*;
 class LongestCommonSuperSequence
{
  public static void main(String args[]){
      String str1="brute";
      String str2="groot";
      
    } 
  static String shortestCommonSupersequence(String str1, String str2) {
       int n=str1.length();
        int m=str2.length();
        String ans="";
        
        int dp[][]=new int[n+1][m+1];
        
        for(int i=0;i<=n;i++)
            dp[i][0]=0;
        
        for(int j=0;j<=m;j++)
            dp[0][j]=0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
             
                if(str1.charAt(i-1)==str2.charAt(j-1))
                {
                  dp[i][j]=1+dp[i-1][j-1];
                }
                
                else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        
        
        int i=n,j=m;
        
        while(i>0 && j>0){
            
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                 ans+=str1.charAt(i-1);
                 i--;
                 j--;
             }
            
            else if(dp[i-1][j]>dp[i][j-1]){
                ans+=str1.charAt(i-1);
                i--;
            }
            
            else{
                ans+=str2.charAt(j-1);
               j--; 
            }
        }
        
        while(i>0){
         ans+=str1.charAt(i-1);
         i--;
        }
        
        while(j>0){
         ans+=str2.charAt(j-1);
         j--;
        }
       
        StringBuilder temp=new StringBuilder();
        temp.append(ans);
        temp.reverse();
        ans=temp.toString();
        
        return ans;
        
    }  
}
