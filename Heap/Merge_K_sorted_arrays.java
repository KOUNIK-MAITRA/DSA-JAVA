import java.io.*;
import java.util.*; 
class Merge_K_sorted_arrays
{
    public static void main(String args[])
    {
        int[][]arr= {{1,2,3},{4,5,6},{7,8,9}};
        int K=3;
        System.out.println(mergeKArrays(arr,K));
    }
    
    static class Data
    {
      int array;
      int index;
      int val;
      
      Data(int array,int index,int val)
      {
          this.array=array;
          this.index=index;
          this.val=val;
      }
      
    }
    
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
      ArrayList<Integer> ans=new ArrayList<>();
      PriorityQueue<Data> pq=new PriorityQueue<>((a,b)->(a.val-b.val));
      
      for(int i=0;i<K;i++)
      {
          pq.add(new Data(i,0,arr[i][0]));
      }
      
      while(!pq.isEmpty())
      {
          Data curr=pq.poll();
          ans.add(curr.val);
          
          if(curr.index+1<arr[curr.array].length)
            pq.offer(new Data(curr.array,curr.index+1,arr[curr.array][curr.index+1]));
      }
      
      return ans;
    }
}

