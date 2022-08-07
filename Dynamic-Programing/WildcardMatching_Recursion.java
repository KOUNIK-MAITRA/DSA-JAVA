import java.io.*;
import java.util.*;
class WildcardMatching_Recursion
{
 public static void main(String args[]){
  String s="aab";
  String p="*a*b";
  System.out.println(isMatch(s,p));
 }
  static boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
       
        return match(n-1,m-1,s,p);
    }
  static boolean match(int i , int j , String s, String p){
        //base case
        if(i<0 && j<0)
            return true;
        
        if(j<0 && i>=0)
         return false;
        
        if(i<0 && j>=0){
            for(int index=0;index<=j;index++)
            {
                char ch=p.charAt(index);
                if(ch!='*')
                    return false;
            }
            return true;
        }
        
       
        
        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')  
            return match(i-1,j-1,s,p);
        
        if(p.charAt(j)=='*') 
            return (match(i-1,j,s,p) || match(i,j-1,s,p)) ;
        
            return false;
    }
}

