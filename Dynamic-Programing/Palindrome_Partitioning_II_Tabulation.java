import java.io.*;
import java.util.*; 
class Palindrome_Partitioning_II_Tabulation
{
 public static void main(String args[]){
  String s="aabaacd";
  System.out.println(minCut(s));
 }
 static int minCut(String s){
  int n=s.length();
  int dp[]=new int[n+1];
  dp[n]=0;
  
  for(int i=n-1;i>=0;i--){
   String temp="";
   int min=Integer.MAX_VALUE;
   for(int j=i;j<n;j++){
     temp+=s.charAt(j);
     if(isPalindrome(temp))
      { int partitions=1+dp[j+1];
         min=Math.min(min,partitions);     
        }
    
    }
   dp[i]=min; 
   }
  
  return dp[0]-1;
 }

 static boolean isPalindrome(String s){
     int left=0;
     int right=s.length()-1;
     while(left<=right){
      if(s.charAt(left)!=s.charAt(right))
       return false;
       left++;
       right--;
        }
        return true;
    }
}
