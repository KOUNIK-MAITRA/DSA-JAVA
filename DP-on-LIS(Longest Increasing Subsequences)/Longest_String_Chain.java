import java.io.*;
import java.util.*;
 class Longest_String_Chain
{
  public static void main(String args[]){
      String words[]={"a","b","ba","bca","bda","bdca"};
      System.out.println(longestStrChain(words));
    }
  static boolean isPossible(String s1,String s2){
      
        if(s1.length()!=s2.length()+1)
            return false;
        
        int i=0;
        int j=0;
        
        while(i<s1.length()){
          if(j<s2.length() && s1.charAt(i)==s2.charAt(j))
          {
            i++;
            j++;
          }
            else
               i++;
        }
        
        if(i==s1.length() && j==s2.length())
        return true;
        else 
        return false;
    }
    
  static public int longestStrChain(String[] words) {
        Arrays.sort(words,(word1, word2)->word1.length() - word2.length());
        int n=words.length;
       
        int []dp=new int[n];
        Arrays.fill(dp,1);
       

        for(int index=1;index<n;index++){
            
            String curr=words[index];
        
            for(int prev_index=0;prev_index<index;prev_index++){
            
             String prev_word=words[prev_index];
             
             if(isPossible(curr,prev_word))
               dp[index]=Math.max(dp[index],dp[prev_index]+1);
         }      
        }
        
        int maxLength=0;
        for(int ele:dp)
            maxLength=Math.max(maxLength,ele);
        
        return maxLength;
        
    }  
}
