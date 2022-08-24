import java.io.*;
import java.util.*;
 class FirstMissingPositive_using_Sorting
{
  public static void main(String args[]){
   int nums[]={3,4,-1,1};
   System.out.println(firstMissingPositive(nums));
  }
  static int firstMissingPositive(int[] nums) {
    //sort the array so the smaller numbers come first
    // our ans lies in the range 1....n+1
    // we start guessing our smallest missing as 1
    // we check if 1 is present if present then we made a wrong guess and
    // our next probable ans is smallestMissing++ i.e 2 and so on
    // if we ever encounter a number > smallest missing 
    // we made a correct guess and we break from the loop and return the smallest missing
    // note : we don't care for 0s and negatives
    Arrays.sort(nums);
    int smallestMissing=1; //probable ans
    for(int i=0;i<nums.length;i++){
     int curr=nums[i];
     if(curr==smallestMissing) smallestMissing++;
     else if(curr>smallestMissing)
      break;
   }
   return smallestMissing;
   }
}
