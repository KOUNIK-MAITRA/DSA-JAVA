import java.io.*;
import java.util.*;
class LongestCommonSubsequence_Tabulation
 {
   public static void main(String args[]){
      String text1="abcde";
      String text2="ace";
      
      System.out.println(longestCommonSubsequence(text1,text2));
  }
  static int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int[n+1][m+1];
       
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
         for(int j=1;j<=m;j++){
          if(text1.charAt(i-1)==text2.charAt(j-1))
            dp[i][j]=1+dp[i-1][j-1];
          else
             dp[i][j]=0+Math.max(dp[i-1][j],dp[i][j-1]);
            }
          
        }
        
        return dp[n][m]; 
     } 
 }
