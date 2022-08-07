import java.io.*;
import java.util.*;
 class Count_Vowel_Permutation
{
  public static void main(String args[]){
      int n=5;
      System.out.println(countVowelPermutation(n));
   }
   static int countVowelPermutation(int n) {
        // 0-->a
        //1-->e
        //2-->i
        //3-->o
        //4-->u
        int mod=(int)(1e9+7);
        long dp[][]=new long[n+1][5];
        
        for(int vowel=0;vowel<5;vowel++)
            dp[1][vowel]=1;
        
        for(int len=2;len<=n;len++){
            
          // dp[len][vowel]= no.of strings of length len ending with vowel
            
         //vowel a can follow strings of length len-1 
        //that ended with e,i, u   
            dp[len][0]=(dp[len-1][1]+dp[len-1][2]+dp[len-1][4])%mod;
            
         //vowel e can follow strings of length len-1 
        //that ended with a,i,     
            dp[len][1]=(dp[len-1][0]+dp[len-1][2])%mod;
                
        //vowel i can follow strings of length len-1 
        //that ended with e,o         
            dp[len][2]=(dp[len-1][1]+dp[len-1][3])%mod;
                
         //vowel o can follow strings of length len-1 
        //that ended with i        
            dp[len][3]=dp[len-1][2];    
         
        //vowel u can follow strings of length len-1 
        //that ended with i,o                
            dp[len][4]=(dp[len-1][2]+dp[len-1][3])%mod;
                
        }
        
        long ans=0;
        
        for(int vowel=0;vowel<5;vowel++)
            {ans+=dp[n][vowel];
             ans%=mod;
            }
        
        return (int)ans;
    } 
}
