import java.io.*;
import java.util.*;
 class MergeSort_InPlace
{
  public static void main (String args[])
  { int nums[]={8,3,4,12,5,6};
    mergeSort(nums,0,nums.length);
    System.out.println(Arrays.toString(nums));
  }
  static void mergeSort(int nums[],int start, int end)
  {
      int n=nums.length;
      if(end-start==1){
       return;}
      
      int  mid=(start+end)/2;
      mergeSort(nums,start,mid); 
      mergeSort(nums,mid,end);
      
      merge(nums,start,mid,end);
    }
   static void merge(int nums[], int start, int mid , int end)
   {
      int mergedArray[]=new int[end-start];
      int i=start;
      int j=mid;
      int k=0;
      
      while(i<mid && j<end){
          
          if(nums[i]<=nums[j]){
            mergedArray[k++]=nums[i++];
            }
          
          else{
              mergedArray[k++]=nums[j++];
            }
     } 
     
     while(i<mid){
         mergedArray[k++]=nums[i++];
        }
     while( j<end){
         mergedArray[k++]=nums[j++];
        } 
    
     for(int it=0;it<mergedArray.length;it++)
     { nums[start+it]=mergedArray[it];
        }
  }
}
