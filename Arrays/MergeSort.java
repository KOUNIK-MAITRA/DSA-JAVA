import java.io.*;
import java.util.*;
 class MergeSort
{
  public static void main (String args[])
  { int nums[]={8,3,4,12,5,6};
    nums=mergeSort(nums);
    System.out.println(Arrays.toString(nums));
  }
  static int[] mergeSort(int nums[])
  {
      int n=nums.length;
      if(n==1){
       return nums;}
      
      int  mid=n/2;
      int left[]=mergeSort(Arrays.copyOfRange(nums,0,mid));
      int right[]=mergeSort(Arrays.copyOfRange(nums,mid,n));
      
      return merge(left,right);
    }
   static int[] merge(int left[], int right[])
   {
      int mergedArray[]=new int[left.length+right.length];
      int i=0;
      int j=0;
      int k=0;
      
      while(i<left.length && j<right.length){
          
          if(left[i]<=right[j]){
            mergedArray[k++]=left[i++];
            }
          
          else{
              mergedArray[k++]=right[j++];
            }
     } 
     
     while(i<left.length){
         mergedArray[k++]=left[i++];
        }
     while( j<right.length){
         mergedArray[k++]=right[j++];
        } 
     return mergedArray;
  }
}
