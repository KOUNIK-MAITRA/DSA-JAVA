import java.io.*;
import java.util.*;
 class Word_Subsets
{
   public static void main(String args[]){
    String []words1 = {"amazon","apple","facebook","google","leetcode"};
    String []words2 = {"e","o"};
    
    System.out.println(wordSubsets(words1,words2));
    }
   static List<String> wordSubsets(String[] words1, String[] words2) {
      List<String> ans=new ArrayList<>();
        int []max_frequency_words2=new int[26];
        for(String word : words2){
            int []charFrequencyOfCurrWord=char_frequency(word);
            
            for(int i=0;i<26;i++)
            {
                max_frequency_words2[i]=Math.max(max_frequency_words2[i],charFrequencyOfCurrWord[i]);
            }
        }
        
        for(String word :words1)
        {
          int[] charFrequencyOfCurrWord=char_frequency(word);
            boolean isAns=true;
          for(int i=0;i<26;i++)
          {
              if(charFrequencyOfCurrWord[i]<max_frequency_words2[i])
              {
                 isAns=false;
                  break;
              }
            
          }
          if(isAns==true)
          ans.add(word);
        }
        
        return ans;
    }
    
    static int[] char_frequency (String s){
        int [] frequencyOfEachChar =new int[26];
        
        for(char ch :s.toCharArray()){
            frequencyOfEachChar[ch-'a']++;
        }
        
        return frequencyOfEachChar;
    }
}

