import java.io.*;
import java.util.*;
 class EditDistance_Recursion
{
  public static void main(String args[]){
      String word1="horse";
      String word2="ros";
      
      System.out.println(minDistance(word1,word2));
   }
   static int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n][m];
      
        return minOperations(n-1,m-1,word1,word2);
    }
   static int minOperations(int i, int j, String word1, String word2)
    {
        if(i<0 && j<0)
            return 0;
        if(i<0 && j>=0)
            return j+1;
        if(j<0 && i>=0)
            return i+1;
        
             
        if(word1.charAt(i)==word2.charAt(j))
            return minOperations(i-1,j-1,word1,word2);
        
        int insert=1+minOperations(i,j-1,word1,word2);
        int delete=1+minOperations(i-1,j,word1,word2);
        int replace=1+minOperations(i-1,j-1,word1,word2);
        
        return Math.min(insert,Math.min(delete,replace));
    } 
}
