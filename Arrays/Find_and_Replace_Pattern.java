import java.util.*;
import java.io.*;
 class Find_and_Replace_Pattern
{
    public static void main(String args[]){
     String words[]={"abc","deq","mee","aqq","dkd","ccc"};
     String pattern="abb";
     System.out.println(findAndReplacePattern(words,pattern));
    }
    static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern))
              res.add(word);
        }
        return res;
    }
    
    static boolean check(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.indexOf(a.charAt(i)) != b.indexOf(b.charAt(i)))
                return false;
        }
        return true;
    }
}
