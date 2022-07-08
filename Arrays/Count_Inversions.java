import java.io.*;
import java.util.*;
class Count_Inversions
{
   static int merge(int arr[], int temp[],int left,int mid, int right) // returns count inversions of an array 
   { 
      int i,j,k;
      int inv_count=0;
      
      i=left; // index for left subarray
      j=mid ; // index for right subarray
      k=left;// index of resultant merged array
      
      while ((i<=mid-1) && (j<=right))
      {
          if(arr[i]<arr[j]) // if the element of the left half is smaller 
          {temp[k++]=arr[i++];// simply copy it to the temp array
            }
          else // if the right half is smaller 
           { temp[k++]=arr[j++];  // copy the right half elemnt to the temp array
              inv_count =inv_count +(mid-1); // i.e add all elemnts right to it in the left half can make pairs with it
            }
        }
        
        // if the right pointer exceeds
        while (i<=mid-1)
        { temp[k++]=arr[i++]; // copy all he elements
        }
        // if the left pointer exceeds 
        while ( j<=right)
        { temp[k++]=arr[j++];
        }
        
        for( i=left;i<=right;i++)
        { arr[i]=temp[i]; // copy all the elements to the original array
        }
      return inv_count;
     }
    
    static int mergeSort(int arr[], int temp[],int left ,int right)
    {  int mid,inv_count=0;
       if(right>left) // no need to split if there is only one element
       { mid=(right+left)/2; // find the mid to split the array
           
           inv_count+=mergeSort(arr,temp,left,mid); // recurrsive call to find the no.of inversion in the first half
           inv_count+=mergeSort(arr,temp,mid+1,right); // recurrsive call to find the no.of pairs in the second half
           
           inv_count+=merge(arr,temp,left,mid+1,right); // finds the total inv_count of both the arrays 
         }
        return inv_count;
    }
   
   public static void main(String args[])
   { int arr[]={5,3,2,4,1};
      int n=arr.length;
      int temp[]=new int [n];
      int ans =mergeSort( arr,  temp,0 ,n-1);
      System.out.println(ans);
    }
}