import java.io.*;
import java.util.*;
class Minimum_Genetic_Mutation {

    static class Gene
    {
        String gene;// gene string
        int mutations;// no.of mutations required to form the string

        Gene(String gene,int mutations)
        {
            this.gene=gene;
            this.mutations=mutations;
        }
    }

    static int minMutation(String start, String end, String[] bank) 
    {
        HashSet<String> bankSet=new HashSet<>();// converting String[] bank to hashset for easy lookup
        for(String gene : bank) 
            bankSet.add(gene);

        if(!bankSet.contains(end))// if the string end is not only present in bank then return -1
            return -1;

        char choices[]={'A','C','G','T'};// char array of our choices

        //Queue for our BFS traversal
        // level is denonated by the no.of mutations 
        Queue<Gene> queue=new LinkedList<>();
        queue.offer(new Gene(start,0));// we need 0 mutations to make start gene 
        // so no.of mutations for start gene is 0

        HashSet<String> visited=new HashSet<>();// a visited set to store already formed mutations
        visited.add(start);// add the start gene to visisted

        while(!queue.isEmpty()){

            Gene curr=queue.poll();
            String currGene=curr.gene;
            int currMutation=curr.mutations;

            if(currGene.equals(end))// if our curr gene is the one we are looking for
                return currMutation;// return the no.of mutations

            //find all possible mutations of currGene
            char[] currGeneArray=currGene.toCharArray();

            // replace each character of the gene string with our 4 choices at a time
            for(int i=0;i<8;i++)
            {   
                char curr_ch=currGeneArray[i];

                for(int j=0;j<choices.length;j++)
                {
                    currGeneArray[i]=choices[j];
                    String newMutation=new String(currGeneArray);

                    // if the new gene formed is not previously visited and is a valid gene
                    // add it to the queue and increase the no.of mutation by 1
                    if(!visited.contains(newMutation) && bankSet.contains(newMutation))
                    {
                        queue.offer(new Gene(newMutation,currMutation+1));
                        visited.add(newMutation);
                    }

                }

                currGeneArray[i]=curr_ch;// undo the character replacement to preserve the string
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String []bank = {"AAAACCCC","AAACCCCC","AACCCCCC"};
        System.out.println(minMutation(start,end,bank));
    }
}