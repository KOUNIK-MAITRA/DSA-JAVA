import java.io.*;
import java.util.*; 
class Palindrome_Partitioning_II_Memorization
{
 public static void main(String args[]){
  String s="aabaacd";
  System.out.println(minCut(s));
 }
 static int minCut(String s){
  int n=s.length();
  int dp[]=new int[n];
  Arrays.fill(dp,-1);
  return minPartitions(0,s,n,dp)-1;
 }
 static int minPartitions(int index, String s, int n,int[]dp){
   if(index==n)
     return 0;
   if(dp[index]!=-1)
   return dp[index];
   String temp="";
   int min=Integer.MAX_VALUE;
   for(int j=index;j<n;j++){
     temp+=s.charAt(j);
     if(isPalindrome(temp))
      { int partitions=1+minPartitions(j+1,s,n,dp);
         min=Math.min(min,partitions);     
        }
    
    }
    return dp[index]=min;
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
