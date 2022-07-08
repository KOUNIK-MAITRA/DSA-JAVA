import java.io.*;
import java.util.*;
class Two_Sum_HashTable
{ 
    static ArrayList<Integer> TwoSum(int a[], int sum)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<a.length;i++)
        { if(map.containsKey(sum-a[i]))
            {ans.add(i);
             ans.add(map.get(sum-a[i]));
             break;
            }
          else
          { map.put(a[i],i);
            }
        }
        
         return ans;
    }
    public static void main(String args[])
    { int a[] ={2,7,11,15};   
      System.out.println(TwoSum(a,18));
   }
}