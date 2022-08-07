import java.io.*;
import java.util.*; 
class Longest_Repeating_Character_Replacement
{
    public static void main(String args[]){
      String s = "ABAB"; int k = 2;
      System.out.println(characterReplacement(s,k));
      }
     static boolean isValid (int left, int right,int maxFreq,int k)
    {
        int windowLength=(right-left)+1;
        int no_of_replacements=windowLength-maxFreq;
        
        if(no_of_replacements>k)
            return false;
        
        return true;
    }
    static int characterReplacement(String s, int k) {
       
        int n=s.length();
        int left=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int right=0;
        int max=0;
        
        while(right<n){
            
            char currChar=s.charAt(right);
            map.put(currChar,map.getOrDefault(currChar,0)+1);
        
            while(!isValid(left,right,Collections.max(map.values()),k))
            {
               map.put(s.charAt(left),map.get(s.charAt(left))-1);
               left++;
            }
                
            max=Math.max(max,(right-left+1));  
            right++;
        }
        return max;
    }
}
