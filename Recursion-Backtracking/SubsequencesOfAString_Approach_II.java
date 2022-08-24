import java.io.*;
import java.util.*;
class SubsequencesOfAString_Approach_II
{
public static void main(String args[]){
  String s="abc";  int n=3;
  ArrayList<String> res=new ArrayList<>();
  allSubsequences(0,s,n,res);
 }
static void allSubsequences(int index,String s,int n,ArrayList<String> res){
  if(index==n)    
  {System.out.println(res); 
   return;}
   
   res.add(s.charAt(index)+"");
   allSubsequences(index+1,s,n,res);
   res.remove(res.size()-1);
   allSubsequences(index+1,s,n,res);
 }
}