import java.io.*;
import java.util.*;
class AlienDictionary
{
    static String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<K;i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<N-1;i++)
        {
            String word1=dict[i];
            String word2=dict[i+1];

            int len=Math.min(word1.length(),word2.length());
            for(int index=0;index<len;index++)
            {
                if(word1.charAt(index)!=word2.charAt(index))
                {
                    adj.get(word1.charAt(index)-'a').add(word2.charAt(index)-'a'); 
                    break;
                }
            }
        }

        int indegree[]=new int[K];
        for(ArrayList<Integer> nodes : adj)
        {
            for(int node: nodes)
            {
                indegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<K;i++)
        {
            if (indegree[i]==0)
                queue.offer(i);
        }
        String ans="";
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            ans+=(char)(curr+'a');

            for(int neighbour: adj.get(curr))
            {
                indegree[neighbour]--;
                if(indegree[neighbour]==0)
                {
                    queue.offer(neighbour);
                }
            }
        }

        return  ans;
    }

    public static void main(String args[])
    {
        int N = 5; int K = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};
        System.out.println(findOrder(dict,N,K));
    }
}