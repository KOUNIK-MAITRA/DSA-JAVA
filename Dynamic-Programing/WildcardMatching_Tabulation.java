import java.io.*;
import java.util.*;
class WildcardMatching_Tabulation
{
 public static void main(String args[]){
  String s="aab";
  String p="c*a*b";
  System.out.println(isMatch(s,p));
 }
 static boolean isMatch(String s, String p) {
       int n=s.length();
        int m=p.length();
        int[][]dp=new int[n+1][m+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++)
        { dp[i][0]=0;
        }
        for(int j=1;j<=m;j++){
            int flag=1;
            for(int index=1;index<=j;index++)
            { char ch=p.charAt(index-1);
              if(ch!='*')
              {flag=0;
                  break;
                }
            }
            dp[0][j]=flag;
        }
       for(int i=1;i<=n;i++)
        {for(int j=1;j<=m;j++)
          {
           if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?')  
              dp[i][j]=dp[i-1][j-1];
        
           else if(p.charAt(j-1)=='*') 
             dp[i][j]=(dp[i-1][j]==1 || dp[i][j-1]==1) ? 1 : 0;
           else
            dp[i][j]= 0;
            }
        }
        return dp[n][m]==1 ? true : false;
    }
}

