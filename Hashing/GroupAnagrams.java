import java.io.*;
import java.util.*; 
class GroupAnagrams
{
   public static void main(String args[]){
       String [] strs= {"eat","tea","tan","ate","nat","bat"};
       System.out.println(groupAnagrams(strs));
    }
   static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map= new HashMap<>();
        
        for(String s :strs)
        {
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            String str= new String(ch);
           
            if(map.containsKey(str))
            {
             map.get(str).add(s); 
            }
            else
            {
                List<String> l=new ArrayList<>();
                l.add(s);
                map.put(str,l);
            }
        }
        
     
         return new ArrayList<>(map.values());
    } 
}
