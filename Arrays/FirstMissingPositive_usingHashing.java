import java.io.*;
import java.util.*;
 class FirstMissingPositive_usingHashing
{
 public static void main(String args[]){
     int nums[]={3,4,-1,1};
     System.out.println(firstMissingPositive(nums));
 }
 static int firstMissingPositive(int[] nums) {
   // our probable ans lies from 1....n+1
   // we add all the numbers in nums to an hashset ignoring the negatives and 0s
   //then we loop through our range of probable ans i.e 1 to n+1
   //the moment we find the first number in our ans range that is not present in the set
   // we return it
   int n=nums.length;
   HashSet<Integer> set= new HashSet<>();
   for(int ele : nums){
     if(ele>=0)
      set.add(ele); 
    }
   for(int i=1;i<=n+1;i++){
     if(!set.contains(i))
      return i;
    }
    return -1;
   }
}
