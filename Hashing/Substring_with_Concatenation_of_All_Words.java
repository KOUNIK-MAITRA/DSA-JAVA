import java.io.*;
import java.util.*; 
class Substring_with_Concatenation_of_All_Words
{
    public static void main(String args[]){
        String s="barfoothefoobarman";
        String[] words={"foo","bar"};
        System.out.println(findSubstring(s,words));
    }
    static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res= new ArrayList<Integer>();
        HashMap<String,Integer> map_countWords=new HashMap<>();
        
        for(String word : words)
        map_countWords.put(word,map_countWords.getOrDefault(word,0)+1);
        
        int wordLength=words[0].length(); // length of each word in words array
        int numberOfWords=words.length;// total no.of words in word array
        int substringLength= wordLength*numberOfWords; //length of apt substring
        
        // check for all substrings of length substringLength 
        for(int i=0;i<=s.length()-substringLength;i++){
            String sub=s.substring(i,i+substringLength);
            if(isConcat(sub,map_countWords,wordLength))//check if it is a valid substring
                res.add(i);   //add it to the resut if it is a valid substring
        }
        
        return res;
    }
    
    static boolean isConcat(String sub, HashMap<String,Integer> map_countWords,int wordLength){
       
        HashMap<String,Integer> map_seen=new HashMap<String,Integer>();
        //check for every word of length "wordLength"
        for(int i=0;i<=sub.length()-wordLength;i+=wordLength){
            String tempWord=sub.substring(i,i+wordLength);
            map_seen.put(tempWord,map_seen.getOrDefault(tempWord,0)+1);//put the words in the the map along with their frequency
        }
        
        return map_seen.equals(map_countWords);// if both the maps are similar then it is a valid substring        
    }
}
