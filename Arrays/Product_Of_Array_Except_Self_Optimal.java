import java.io.*;
import java.util.*; 
class Product_Of_Array_Except_Self_Optimal
{
   public static void main(String args[]){
    int nums[]={1,2,3,4};
    System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
     static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        
        int prefix=1;
        for(int i=0;i<n;i++)
        {
            ans[i]=prefix; // stores the prefix product for the index i
            prefix=prefix*nums[i]; // updated prefix
        }
        
        int postfix=1;
        for(int i=n-1;i>=0;i--) //  iterate from back
        {
            ans[i]=postfix*ans[i]; // stores the prefix[i] x postfix[i]
            postfix=postfix*nums[i]; // updated postfix
        }
        
     
        return ans;
    }
}
