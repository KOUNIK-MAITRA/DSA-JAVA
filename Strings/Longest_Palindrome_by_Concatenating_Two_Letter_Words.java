import java.io.*;
import java.util.*;
class  Longest_Palindrome_by_Concatenating_Two_Letter_Words {
    static int longestPalindrome(String[] words) 
    {

        int maxLen=0;
        HashMap<String,Integer> map=new HashMap<>();

        for(String word : words)
        {
            //reverse the word
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            String reverse = sb.reverse().toString();

            // check if the map contains the reverse word
            if(map.containsKey(reverse))
            {
                // this means both the word and the reverse word are present
                // they can be concatenated to form a palindrome 
                maxLen+=word.length()+reverse.length();
                map.put(reverse,map.get(reverse)-1);// isnce we used 1 reverse word decrease its freq

                if(map.get(reverse)==0)// if frequency becomes 0 remove from the map
                    map.remove(reverse);
            }

            // if the word doesnot have a reverse pair present in the map
            // add it to the map or increase its frequency

            else {
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }

        for(String word : map.keySet())
        { 
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            String reverse = sb.reverse().toString(); 

            // if the word is a palindrome word
            // and is present only once
            // it could be used in the middle
            if(word.equals(reverse) && map.get(word)==1)
            {
                maxLen+=word.length();
                break;
            }
        }

        return maxLen;
    }

    public static void main(String args[])
    {
        String words[] = {"ab","ty","yt","lc","cl","ab"};
        System.out.println(longestPalindrome(words));
    }
}