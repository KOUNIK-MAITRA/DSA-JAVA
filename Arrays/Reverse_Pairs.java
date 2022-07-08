import java.io.*;
import java.util.*;
 class Reverse_Pairs
{    
    static int merge(int nums[],int low, int mid, int high)
    {   
        int count=0;
        int j=mid+1;
        for(int i=low;i<=mid;i++)
        { 
            while(j<=high && nums[i]>(2*(long)nums[j])) // check for the condition for reverse pairs
            { j++;
            }
            count+=(j-(mid+1)); // no.of possible reverse pairs
        }
        
        ArrayList<Integer> temp=new ArrayList<>(); // temp array to store the elements
        
        // merging the sub arrays as in merge sort
        int left=low, right=mid+1;
        
        while(left<=mid && right<=high)
        { 
            if(nums[left]<=nums[right])
            {temp.add(nums[left++]);
            }
            else 
            {temp.add(nums[right++]);
            }
        }
        
        while(left<=mid)
        { temp.add(nums[left++]);
        }
        while(right<=high)
        {
           temp.add(nums[right++]);
        }
        
        for(int i=low;i<=high;i++)
        {nums[i]=temp.get(i-low);} // i-low is imp
        return count; 
    }
    static int mergeSort(int []nums, int low, int high)
    { if(low>=high)
       return 0;
       int mid=(low+high)/2;
       int inv= mergeSort(nums,low,mid); // no.of inversion in left half
       inv+=mergeSort(nums,mid+1,high);// no.of inversion in right half
       
       inv+=merge(nums,low,mid,high); // no.of inversion in complete left half and complete second half
       return inv;
    }
    
    static int reversePairs(int nums[])
    {
        return mergeSort(nums,0,nums.length-1);
    }
    public static void main(String args[])
    {int nums[]={2,4,3,5,1};
      System.out.println(reversePairs(nums));
     }
}
