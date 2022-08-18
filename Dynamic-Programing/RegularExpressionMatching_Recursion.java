import java.io.*;
import java.util.*;
 class RegularExpressionMatching_Recursion
{
  public static void main(String args[]){
      String s="ab"; String p=".*";
      System.out.println(isMatch(s,p));
  }
  static boolean isMatch(String s, String p) {
      return isMatch(s.length()-1,p.length()-1,s,p);
    }
    
  static boolean isMatch(int i, int j,String s, String p){
      // if both i and j are out of bounds then we have matched all characters
      if(i<0 && j<0) 
       return true;
      // if we have exhausted all characters in p but we have characters left is s
      if(j<0 ) 
       return false;
      //if we have exhausted all characters in s but we have characters left is p
      // then the strings can match only if all remaining characters in p are *
      if(i<0 && p.charAt(j)!='*') 
       return false;
      
      if(i<0 && p.charAt(j)=='*') 
       return isMatch(i,j-2,s,p);
      
      // if the characters match or the character in p is '.'
      // they have matched and we check for rest of the string
      if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')
        return isMatch(i-1,j-1,s,p);
      // if the character in p in a '*'  
      if(p.charAt(j)=='*'){
         // if we consider to not take the star
         // we simply ignore it and the character before it and
         // take our j pointer from j to j-2
         boolean notTake=isMatch(i,j-2,s,p);
         // we can choose to use the * if and only if the character before *
         // matches with character at i in string s
         // and we move the i pointer to check for the remianing of the string s
         boolean take=false;
           if(s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.')
               take=isMatch(i-1,j,s,p);
         
               
         return take || notTake;
       }
        
        return false;
    }
}
