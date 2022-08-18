import java.io.*;
import java.util.*;
class RegularExpressionMatching_Memorization
{
 public static void main(String args[]){
    String s="ab"; String p=".*";
    System.out.println(isMatch(s,p));
  }
 static boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int dp[][]=new int [n][m];
        for(int []arr:dp)
        Arrays.fill(arr,-1);
        return isMatch(n-1,m-1,s,p,dp)==1 ? true : false;
    }
    
 static int isMatch(int i, int j,String s, String p,int [][]dp){
      if(i<0 && j<0) return 1;
      if(j<0 ) return 0;
      if(i<0 && p.charAt(j)!='*') return 0;
      if(i<0 && p.charAt(j)=='*')  return isMatch(i,j-2,s,p,dp);
      
      if(dp[i][j]!=-1)
       return dp[i][j];
        
      if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')
        return dp[i][j]=isMatch(i-1,j-1,s,p,dp);
        
      if(p.charAt(j)=='*'){
         
        int notTake=isMatch(i,j-2,s,p,dp);
         
        int take=0;
          if(s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.')
           take=isMatch(i-1,j,s,p,dp);
           
          return  dp[i][j]= (take==1 || notTake==1)?1 :0;
       }
        return 0;
    }
}
