// reverse the substring and find the longest common subsequence between the string and reversed string
import java.io.*;
import java.util.*;
class LongestPalindromicSubsequence_Memorization
{
 public static void main(String args[]){
     String s="bbbab";
     System.out.println(longestPalindromeSubseq(s));
  }
 static int longestPalindromeSubseq(String s) {
     StringBuilder temp=new StringBuilder();
        temp.append(s);
        temp.reverse();
        int n=s.length();
        String s1=s;
        String s2=temp.toString();
        int dp[][]=new int[n][n];
        for(int arr[]:dp)
            Arrays.fill(arr,-1);
        return LCS(n-1,n-1,s1,s2,dp);
    }
 static  int LCS(int i , int j ,String s1, String s2,int[][]dp){
        if(i<0 || j<0)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=1+LCS(i-1,j-1,s1,s2,dp);
        else
            return dp[i][j]=0+Math.max(LCS(i-1,j,s1,s2,dp),LCS(i,j-1,s1,s2,dp));
    } 
}
