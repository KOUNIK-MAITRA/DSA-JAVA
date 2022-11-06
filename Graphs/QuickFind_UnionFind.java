import java.io.*;
import java.util.*; 
class QuickFind_UnionFind
{
  private int []id;
  QuickFind_UnionFind(int N)
  {
      id=new int[N];
      for(int i=0;i<N;i++)
        id[i]=i;
  }
  public boolean isConnected(int query1, int query2)
  {
      return id[query1]==id[query2];
  }
  public void union(int query1,int query2)
  {
      int query1_id=id[query1];
      int query2_id=id[query2];
      for(int i=0;i<id.length;i++)
      {
          if(id[i]==query1_id)
            id[i]=query2_id;
      }
  }
  public static void main(String args[])
  { 
      int N=10;
      
  }
}