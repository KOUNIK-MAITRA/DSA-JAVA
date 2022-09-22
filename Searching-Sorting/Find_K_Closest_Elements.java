import java.io.*;
import java.util.*;
class Find_K_Closest_Elements {
    public static void main(String args[])
    {
      int arr[]={10,20,30,40,50,60};
      int x=45;
      int k=4;
      System.out.println(findClosestElements(arr,k,x));
    }
    static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0;
        int high=arr.length-1;
        int mid=0;
        
        // use binary search to find the element closest to x
        while(low<=high)
        {
            mid=(low+high)/2;
            if(arr[mid]==x){
                break;
            }
            else if(arr[mid]<x){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        // the position of element closest to x is in mid now
        int left=-1;
        int right=-1;
       
        // handling edge cases
        if(mid>0){
          left=mid-1;
          right=mid;  
        }
        else
        {
            left=mid;
            right=mid+1;
        }
         
        
        List<Integer> ans=new ArrayList<Integer>();
        
        // search for the k closest elements in the left and right half
        while(left>=0 && right <arr.length && k>0)
        {
            if( Math.abs(arr[left]-x) <= Math.abs(arr[right]-x) ){
                ans.add(arr[left]);
                left--;
                k--;
            }
            else{
                ans.add(arr[right]);
                right++;
                k--; 
            }
        }
       
        // if we have crossed our right boundary but k is still not 0
        // we need to add elements from the left half
        while(k>0 && left>=0){
            ans.add(arr[left]);
            left--;
            k--;           
        }
        // if we have crossed our left boundary but k is still not 0
        // we need to add elements from the right half
        while(k>0 && right<arr.length){
            ans.add(arr[right]);
            right++;
            k--; 
        }
        
        // sort the ans
        Collections.sort(ans);
        return ans;
    }
}