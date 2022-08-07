import java.io.*;
import java.util.*;
class Kth_Element_Of_Two_Sorted_Arrays
{
   public static void main(String args[]){
    int nums1[]={2,3,6,7,9};
    int nums2[]={1,4,8,10};
    
    int n=nums1.length;
    int m=nums2.length;
    int k=5;
    System.out.println(kth_Element(nums1,n,nums2,m,k));
    }
   static int kth_Element(int nums1[], int n, int nums2[], int m,int k){
       if(n>m)
       { return kth_Element(nums2,m,nums1,n,k);
        }
        
       int low=Math.max(0,k-m);
       int high=Math.min(n,k);
       
       while(low<=high){
           int mid=(low+high)/2;
           
           int cut1=mid;
           int cut2=k-cut1;
           
           int left1= cut1==0 ? Integer.MAX_VALUE : nums1[cut1-1];
           int left2= cut2==0 ? Integer.MAX_VALUE : nums2[cut2-1]; 
           
           int right1= cut1==n ? Integer.MIN_VALUE : nums1[cut1];
           int right2= cut2==m ? Integer.MIN_VALUE : nums2[cut2];
           
           if(left1<=right2 && left2<=right2)
            return Math.max(left1,left2);
            else if (left1>right2)
             high=mid-1;
            else
            low=mid+1;
        }
        return -1;
    } 
}
