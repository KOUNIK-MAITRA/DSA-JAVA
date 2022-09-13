import java.io.*;
import java.util.*;
class PalindromePartioning
{
  public static void main(String args[])
  {
      String s="aabb";
      System.out.println(partition(s));
  }
  static List<List<String>> partition(String s) 
  {
      List<List<String>> ans= new ArrayList<>();
      List<String> res= new ArrayList<>();  
      palindromePartioning(0,s,res,ans);
      return ans;  
  }
   
   static void palindromePartioning(int index,String s,List<String> res, List<List<String>> ans)
  {
        if(index==s.length()) // if we reach the end of the string we cannot partition any more
       {
            ans.add(new ArrayList<>(res));// add the partitions to the ans
            return;
        }
        
       for(int i=index;i<s.length();i++) // find the index i where we can make a partition such that the substring s[index to i] is palindrome
        {
          if(isPalindrome(index,i,s))
          {
              res.add(s.substring(index,i+1)); // add this partition to the res
              palindromePartioning(i+1,s,res,ans);// check for partitions in the remaining string
              res.remove(res.size()-1);// remove this curr partition from res while backtracking
          }
        }
   }
    
  static boolean isPalindrome(int left, int right,String s)
  {
      while(left<=right)
      {
        if(s.charAt(left)!=s.charAt(right))
         return false;
        left++; right--;  
      }
      return true;  
   }
}
