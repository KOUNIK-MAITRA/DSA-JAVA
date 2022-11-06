import java.io.*;
import java.util.*;
class WordSearch_II {
    static List<String> findWords(char[][] board, String[] words)
    {
        int m=board.length;
        int n=board[0].length; 

        List<String> found= new ArrayList<>();  

        HashMap<Character,ArrayList<ArrayList<Integer>>> map = new HashMap<>();

        for(char i='a'; i<='z'; i++)
            map.put(i,new ArrayList<ArrayList<Integer>>());

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                char ch=board[i][j];
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(i);
                temp.add(j);
                map.get(ch).add(temp);
            }
        }

        for(String word : words){
            if(isPresent(board,word,map))
                found.add(word);
        }

        return found;  
    }

    static boolean isPresent(char[][]board,String word,HashMap<Character,ArrayList<ArrayList<Integer>>> map)
    {
        for(ArrayList<Integer> indices : map.get(word.charAt(0)))
        {
            int row=indices.get(0);
            int col=indices.get(1);
            if(DFS(row,col,board,word,0))
                return true;
        }
        return false;
    }

    static boolean DFS(int row,int col, char[][] board,String word,int pos)
    {
        int m=board.length;
        int n=board[0].length;

        if(pos==word.length())
            return true;
        if(row<0||row>=m||col<0||col>=n||board[row][col]!=word.charAt(pos))
            return false;

        char temp=board[row][col];
        board[row][col]='#';

        boolean found=DFS(row-1,col,board,word,pos+1)||
            DFS(row+1,col,board,word,pos+1)|| 
            DFS(row,col-1,board,word,pos+1)||
            DFS(row,col+1,board,word,pos+1);

        board[row][col]=temp;
        return found;
    }

    public static void main(String args[])
    {
        char [][]board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[]words = {"oath","pea","eat","rain"};
        System.out.println(findWords(board,words));

    }
}