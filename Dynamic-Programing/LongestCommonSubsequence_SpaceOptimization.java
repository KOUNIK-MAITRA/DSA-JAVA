import java.io.*;
import java.util.*;
 class LongestCommonSubsequence_SpaceOptimization
 {
  public static void main(String args[]){
      String text1="abcde";
      String text2="ace";
      
      System.out.println(longestCommonSubsequence(text1,text2));
 }
 static int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int prev[]=new int[m+1];
       
        prev[0]=0;
        for(int i=1;i<=n;i++){
        int curr[]=new int[m+1];
         for(int j=1;j<=m;j++){
         if(text1.charAt(i-1)==text2.charAt(j-1))
            curr[j]=1+prev[j-1];
        else
             curr[j]=0+Math.max(prev[j],curr[j-1]);
            }
            prev=curr;
        }
        
        return prev[m];
    } 
}
