import  java.io.*;
import java.util.*;
class Longest_Consequtive_Sequence
{ 
    static int longestConsequtive(int nums[])
    { Set<Integer> hashSet=new HashSet<Integer>();
        for(int ele: nums)
         hashSet.add(ele);
         
         int longestStreak=0;
         for(int num :nums)
         { if(!hashSet.contains(num-1))
             { int currNum=num;
                 int currStreak=1;
                 
                 while(hashSet.contains(currNum+1))
                 { currNum+=1;
                     currStreak+=1;
                    }
                    longestStreak=Math.max(longestStreak,currStreak);
                }
            }
         return longestStreak;
    }
    public static void main (String args[])
    { 
       int nums[]={100,4,200,1,3,2};
       System.out.println(longestConsequtive(nums));
       
    }
}