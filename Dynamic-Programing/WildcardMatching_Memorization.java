import java.io.*;
import java.util.*;
class WildcardMatching_Memorization
{
 public static void main(String args[]){
  String s="aab";
  String p="*a*b";
  System.out.println(isMatch(s,p));
 }
 static boolean isMatch(String s, String p) {
       int n=s.length();
        int m=p.length();
        int[][]dp=new int[n][m];
        for(int arr[]:dp)
            Arrays.fill(arr,-1);
        return match(n-1,m-1,s,p,dp)==1 ? true : false;
    }
  static int match(int i , int j , String s, String p,int[][]dp){
        //base case
        if(i<0 && j<0)
            return 1;
        
        if(j<0 && i>=0)
         return 0;
        
        if(i<0 && j>=0){
            for(int index=0;index<=j;index++)
            {
                char ch=p.charAt(index);
                if(ch!='*')
                    return 0;
            }
            return 1;
        }
        
        if(dp[i][j]!=-1)
        return dp[i][j];
        
        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')  
            return dp[i][j]=match(i-1,j-1,s,p,dp);
        
        if(p.charAt(j)=='*') 
            return dp[i][j]=(match(i-1,j,s,p,dp)==1 || match(i,j-1,s,p,dp)==1) ? 1 : 0;
        
            return 0;
    }
}

