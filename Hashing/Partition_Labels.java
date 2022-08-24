import java.io.*;
import java.util.*;
class Partition_Labels
{
   public static void main(String args[])
   {
      String s="ababcbacadefegdehijhklij";
      System.out.println(partitionLabels(s));
    } 
   static List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        
        List<Integer> ans= new ArrayList<>();
        int max=0;
        int prev=-1;
        
        for(int i=0;i<s.length();i++){
            
            char ch=s.charAt(i);
            
            max=Math.max(max,map.get(ch));
            
            if(i==max){
                //partition 
                ans.add(max-prev);
                prev=max;
            }
        }
        
        return ans;
    }  
}
