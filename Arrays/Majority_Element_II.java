import java.io.*;
import java.util.*;
class Majority_Element_II
 { 
      static List<Integer> MajorityEle(int arr[])
     {  List<Integer> ans = new ArrayList<>();
         
         int cand_1=-1;
         int cand_2=-1;
         
         int count_1=0;
         int count_2=0;
         
         for(int i=0;i<arr.length;i++)
         { if(arr[i]==cand_1)
             count_1++;
             else if(arr[i]==cand_2)
             count_2++;
             else if(count_1==0)
             { cand_1=i;
                 count_1=1;
                }
                else if(count_2==0)
                { cand_2=i;
                    count_2=1;
                }
                else 
                { count_1--;
                    count_2--;
                }
            }
         
          int freq_1=0,freq_2=0;
          for(int i=0;i<arr.length;i++)
          { if(arr[i]==arr[cand_1])
              freq_1++;
            if(arr[i]==arr[cand_2])
            freq_2++;
            }
            
            if(freq_1>arr.length/3)
              ans.add(arr[cand_1]);
              
              if(freq_2>arr.length/3)
                ans.add(arr[cand_2]);
                
         return ans;
        }
        
     public static void main(String args[])
     { int []arr={1,2};
       List<Integer> ans = new ArrayList<>();
      
       System.out.println(MajorityEle(arr));
        }
}