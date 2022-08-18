import java.io.*;
import java.util.*;
class WordLadder
{
    public static void main(String args[]){
     String beginWord="hit";
     String endWord="cog";
     List<String> wordList=new ArrayList<>();
     Collections.addAll(wordList,"hot","dot","dog","lot","log","cog");
     System.out.println(ladderLength(beginWord,endWord,wordList));
    }
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //create a set to add all the words in the wordList
        HashSet<String> set = new HashSet<>(wordList); 
        // if it doesnot contain the endWord then return 0
        if(!set.contains(endWord))
          return 0;
        //create a set to store all the words that have been visited
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);//add the begin word to the set
        //we are going to use BFS ro fin the shortest path 
        //declare a queue to implement the dfs
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord); //add the begin word to the queue
        
        int changes=1; // initiaize changes to 1
        
        //traverse while the queue is not empty
        while(!queue.isEmpty()){
            int size=queue.size();// indicates no.of words in the queue           
            for(int i=0;i<size;i++)//traverse for each word in the queue
            {
               String word=queue.poll(); // pull out the curr word 
               
                if(word.equals(endWord)) // if we have found the endWord
                    return changes;   // return the no.of chamges required
                
               
                for(int j=0;j<word.length();j++)//to traverse each letter of the word
                {  char arr[]=word.toCharArray();
                   for(char ch='a';ch<='z';ch++)
                    {//try replacing each letter of the word with all 26 alphabets
                        arr[j]=ch;
                        String newWord= new String(arr);
                        //if our set contains the newWord and it has not been visited yet
                        if(set.contains(newWord) && !visited.contains(newWord))
                        {
                            queue.add(newWord);//add it to the queue
                            visited.add(newWord);//mark it as visited
                        }
                    }
                }
            }
            //increment the no.of changes after traversing each word in the queue   
            changes++;        
        }
         return 0;
    }  
}
