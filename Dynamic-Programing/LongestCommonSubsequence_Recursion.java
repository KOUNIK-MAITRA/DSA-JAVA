import java.io.*;
import java.util.*;
 class LongestCommonSubsequence_Recursion
 {
  public static void main(String args[]){
      String text1="abcde";
      String text2="ace";
      
      System.out.println(longestCommonSubsequence(text1,text2));
 }
 static int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        
        return lengthOfLCS(n-1,m-1,text1,text2);
    } 
 static int lengthOfLCS(int i, int j, String text1,String text2){
     if(i<0 || j<0)
      return 0;
      
     if(text1.charAt(i)==text2.charAt(j))
      return 1+lengthOfLCS(i-1,j-1,text1,text2);
     else
      return 0+Math.max(lengthOfLCS(i-1,j,text1,text2),lengthOfLCS(i,j-1,text1,text2));
    }   
}
