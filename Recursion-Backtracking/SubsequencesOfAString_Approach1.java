import java.io.*;
import java.util.*;
class SubsequencesOfAString_Approach1
{
  public static void main(String args[]){
  String s="abc";  
  ArrayList<String> res=new ArrayList<>();
  allSubsequences("",s,res);
  System.out.println(res);
 }
 static void allSubsequences(String processed, String unprocessed,ArrayList<String> res){
      if(unprocessed.isEmpty())
      {res.add(processed); 
       return;}
      
      char ch=unprocessed.charAt(0);
      allSubsequences(processed+ch,unprocessed.substring(1),res);
      allSubsequences(processed,unprocessed.substring(1),res);
    }
}