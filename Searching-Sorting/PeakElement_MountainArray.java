import java.io.*;
import java.util.*;
class PeakElement_MountainArray
{
    public static void main (String args[])
    {
        int arr[]={3,5,3,2,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
     static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
    
       //peak element is greater than its left and right elements!
    
      while(start<=end){
	
        int mid = start+(end-start)/2;
		
        if(arr[mid+1] < arr[mid] && arr[mid -1] < arr[mid]){
            return mid;
        }
       
        else if(arr[mid+1]>arr[mid]){
            start=mid+1;
        } else{
            end = mid-1;    
        }
      }
       return -1;   // if no peak element so return -1
    }
}

