import java.io.*;
import java.util.*;
class WordLadder_II {
    static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) 
    {
        HashSet<String> set=new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        Queue<List<String>> queue=new LinkedList<>();
        ArrayList<String> usedInLevel= new ArrayList<>();

        List<String> firstWord = new ArrayList<>();
        firstWord.add(beginWord);
        queue.offer(firstWord);

        int level=0;

        while(!queue.isEmpty()){

            List<String> curr=queue.poll();
            //we have move to the next level
            // we need to remove all words in usedInLevel from the set
            if(curr.size()>level){
                level++;
                for(String word:usedInLevel){
                    set.remove(word);
                }
                usedInLevel.clear();
            }

            String currWord=curr.get(curr.size()-1);
            //if we have found our end word
            if(currWord.equals(endWord)){
                //if we have found the word for the first time
                if(ans.size()==0){
                    ans.add(curr);
                }
                else{
                    if(ans.get(0).size()==curr.size()){
                        ans.add(curr);
                    }
                }
            }

            // modifying each word on alphabet at a time
            char currWordArray[]=currWord.toCharArray();
            for(int i=0;i<currWordArray.length;i++){
                char currLetter=currWordArray[i];
                for(char ch='a';ch<='z';ch++){
                    currWordArray[i]=ch;
                    String newWord=new String(currWordArray);
                    if(set.contains(newWord)){
                        usedInLevel.add(newWord);
                        List<String> temp=new ArrayList<>(curr);
                        temp.add(newWord);
                        queue.offer(temp);
                    }
                }
                currWordArray[i]=currLetter;
            }
        }
        return ans;
    }

    public static void main(String args[]){
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(findLadders(beginWord,endWord,wordList));
    }
}