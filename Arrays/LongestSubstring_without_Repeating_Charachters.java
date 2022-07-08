import java.io.*;
import java.util.*;
public class LongestSubstring_without_Repeating_Charachters
{
     static int LongestSubstring(String s)
     { if(s==null||s.length()==0)
         {return 0;
            }
            int max_len=0;
            HashMap<Character,Integer> map=new HashMap<>();
            int left=0;int right=0;
           while (right<s.length())
           { 
               if(map.containsKey(s.charAt(right)))
                 { left=Math.max(map.get(s.charAt(right))+1,left);
                    }
                    map.put(s.charAt(right),right);
                    max_len=Math.max(max_len,right-left+1);
                    right++;
            }
            return max_len;
        }
    public static void main(String args[])
     { String s="abcaabcdba";
         System.out.println(LongestSubstring(s));
    }  
}
