import java.io.*;
import java.util.*;
class DistinctSubsequences_Memorization
 {
 public static void main(String args[]){
      String s="babgbag";
      String t="bag";
      System.out.println(numDistinct(s,t));
   } 
 static int numDistinct(String s, String t) {
      int n=s.length();
        int m=t.length();
        int dp[][]=new int [n][m];
        for(int arr[]:dp)
            Arrays.fill(arr,-1);
        return distinctSubsequences(n-1,m-1,s,t,dp);
    }
    
 static int distinctSubsequences(int i , int j , String s , String t,int [][]dp){
       
        if(j<0)// i.e we have matched all the characters in string t
            return 1;
    // we exhausted  the string s and still could not match all characters in string t    
        if(i<0 && j>=0) 
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
      //if the characters match then we have 2 possible ways
        //either we match them and reduce the strings f(i-1,j-1);
        // or we do not consider this match and search for the character in rest of the string s
        //i.e f(i-1,j)
        if(s.charAt(i)==t.charAt(j))
        return dp[i][j]=distinctSubsequences(i-1,j-1,s,t,dp) + distinctSubsequences(i-1,j,s,t,dp);
        
        //else if the characters donnot match we must search for it in rest of the string s
        else
            return dp[i][j]=distinctSubsequences(i-1,j,s,t,dp);
    }
} 

