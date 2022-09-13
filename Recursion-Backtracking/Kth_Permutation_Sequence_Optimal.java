import java.io.*;
import java.util.*;
 class Kth_Permutation_Sequence_Optimal
{
    public static void main(String args[]){
        int n =4; int k=17;
        System.out.println(getPermutation(n,k));
    }
    static String getPermutation(int n, int k)
    {
      int factorial=1;  
      ArrayList<Integer> num = new ArrayList<>();
      
      for(int i=1;i<n;i++)
      { factorial*=i;
        num.add(i);  
      }
      num.add(n);  
      
      k=k-1;
      String res="";  
      
      while(true)
      {
          res+=num.get(k/factorial);
          num.remove(k/factorial);
          if(num.size()==0) break;
          k=k%factorial;
          factorial/=num.size();
      }
        
      return res;
        
    }
}
