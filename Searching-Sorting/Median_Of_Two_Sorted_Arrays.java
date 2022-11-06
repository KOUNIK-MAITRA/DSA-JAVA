import java.io.*;
import java.util.*;
class Median_Of_Two_Sorted_Arrays
{
    public static void main(String args[]){
        int nums1[]={1,2};
        int nums2[]={3,4};

        System.out.println("Median is " +findMedianSortedArrays(nums1,nums2));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // take num1 as the shorter array
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2,nums1);

        int n=nums1.length;
        int m=nums2.length;

        int low=0; // can take 0 elemnts from the first array
        int high=n;// can take n elements from the first array

        int elements_in_each_half=(n+m+1)/2;

        double median=0.0;

        while(low<=high){
            int mid= (low+high)/2;

            int cut1=mid; //elements in left half from array1
            int cut2=elements_in_each_half-cut1;// elements in left half from array2

            // if no element is taken for left half from num1 or num2 then take MIN
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];

            //if all elements are taken for left half from num1 or num2 then take MAX    
            int right1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];    

            if(left1<=right2 && left2<=right1)// valid partition
            {
                //check if even or odd length
                if((n+m)%2==0) //even length
                {
                    median = (Math.max(left1,left2)+Math.min(right1,right2))/2.0;  
                    return median;
                }
                else //odd
                {
                    median = Math.max(left1,left2); 
                    return median;
                }
            }

            else if(left1>right2){
                high=mid-1;
            }
            else
                low=mid+1;
        }

        return median;

    } 
}
