import java.io.*;
import java.util.*;
class PalindromePairs
{
    public static void main(String args[]){
        String words[]={"abcd","dcba","lls","s","sssll"};
        System.out.println(palindromePairs(words));
    }

    static boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }

    static String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans= new ArrayList<>();

        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++)
            map.put(words[i],i);

        //case 1 : look for empty strings they can pair with strings which are palindrome themselves
        if(map.containsKey("")){
            int emptyStringIndex=map.get("");
            for(int i=0;i<words.length;i++){
                if(isPalindrome(words[i]) && i!=emptyStringIndex){
                    ans.add(Arrays.asList(emptyStringIndex,i));
                    ans.add(Arrays.asList(i,emptyStringIndex));
                }
            }
        }

        //case 2: if s2 is reverse of s1 then s1+s2 and s2+s1 are palindromes
        for(int i=0;i<words.length;i++){
            String currWord=words[i];
            String reverseWord=reverseString(currWord);
            if(map.containsKey(reverseWord) && map.get(reverseWord)!=i){
                ans.add(Arrays.asList(i,map.get(reverseWord)));
            }
        }

        //case3: if s1[0:cut] is palindrome and there exists a string s2 which is reverse of s1[cut:]
        //then s2+s1 is a palindrome pair
        //if s1[cut:] is palindrome and there exists a string s2 which is reverse of s1[0:cut]
        //then s1+s2 is a palindrome pair

        for(String word :words){

            String currWord=word;

            for(int cut=1;cut<currWord.length();cut++){

                String s1=currWord.substring(0,cut);
                String s2=currWord.substring(cut);  

                if(isPalindrome(s1)){
                    String s2rev=reverseString(s2);
                    if(map.containsKey(s2rev))
                        ans.add(Arrays.asList(map.get(s2rev),map.get(currWord)));
                }

                if(isPalindrome(s2)){
                    String s1rev=reverseString(s1);
                    if(map.containsKey(s1rev))
                        ans.add(Arrays.asList(map.get(currWord),map.get(s1rev)));
                }
            }
        }

        return ans;
    }
}
