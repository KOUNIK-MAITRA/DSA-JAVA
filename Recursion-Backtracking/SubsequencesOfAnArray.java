import java.io.*;
import java.util.*;
class SubsequencesOfAnArray
{
public static void main(String args[]){
  int arr[]={3,1,2};  int n=3;
  ArrayList<Integer> res=new ArrayList<>();
  allSubsequences(0,arr,n,res);
 }
static void allSubsequences(int index, int[] arr,int n,ArrayList<Integer> res){
  if(index==n)    
  {System.out.println(res); 
   return;}
   
   res.add(arr[index]);
   allSubsequences(index+1,arr,n,res);
   res.remove(res.size()-1);
   allSubsequences(index+1,arr,n,res);
 }
}