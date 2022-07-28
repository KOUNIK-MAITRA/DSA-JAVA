import java.io.*;
import java.util.*; 
class Product_Of_Array_Except_Self
{
   public static void main(String args[]){
    int nums[]={1,2,3,4};
    System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
   static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[n]; //stores the prefix product of the elements
        int postfix[]=new int[n];//stores the postfix product of the elements
        int ans[]=new int[n];
        
        int pre=1;
        for(int i=0;i<n;i++)
        {
            prefix[i]=pre*nums[i];
            pre=prefix[i];
        }
        
        int post=1;
        for(int i=n-1;i>=0;i--)
        {
            postfix[i]=post*nums[i];
            post=postfix[i];
        }
        
        ans[0]=postfix[1];
        ans[n-1]=prefix[n-2];
        
        for(int i=1;i<n-1;i++)
        {
            ans[i]=prefix[i-1]*postfix[i+1];
        }
        
        return ans;
    }
}
