import java.io.*;
import java.util.*;
class BubbleSort
{
    static void bubbleSort(int arr[], int n)
    {
        for(int i=0;i<n;i++)// runs for n-1 times
        { boolean swap=false;
            for(int j=0;j<n-i-1;j++)// with every pass the right half of the array will be sorted
            {
                if(arr[j]>arr[j+1]) // swap adjacent elements if the previous ele is greater than the next ele
                {   //swap
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true;
                }
            }
            if(!swap) // optimization : if no swap has taken place 
                      // that means arrays is already sorted no need to check further
                break;  
        }
    }

    public static void main(String args[])
    {
        int n=5;
        int arr[]={5,4,3,2,1};
        bubbleSort(arr,n);
        System.out.println(Arrays.toString(arr));
    }
}
